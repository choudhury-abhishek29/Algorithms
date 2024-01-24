package prep.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class CourseScheduleOrder {
//	public int[] findOrder(int numCourses, int[][] prerequisites) {
//		List<List<Integer>> adj_list = getAdjecencyList(numCourses, prerequisites);
//        Set<Integer> visited = new HashSet<Integer>();
//        boolean[] inStack = new boolean[numCourses];
//        Stack<Integer> course_seq = new Stack<Integer>();
//
//        int[] seq = new int[numCourses];
//        
//        for(int c=0;c<numCourses;c++) {
//        	if(!visited.contains(c) && dfs(c, adj_list, visited, inStack, course_seq))
//            	return new int[0];
//        }
//        
//        for(int i=0;i<seq.length;i++)
//        	seq[i]=course_seq.pop();
//        
//        return seq;
//    }
//	
//	private boolean dfs(int course, List<List<Integer>> adj_list, Set<Integer> visited, boolean[] inStack, Stack<Integer> course_seq) {
//        visited.add(course);
//			
//		for(int pre : adj_list.get(course)) {
//			if(visited.contains(pre))
//				return true;
//			
//			if(!visited.contains(pre) && dfs(pre, adj_list, visited, inStack, course_seq))
//				return true;
//			
//		}
//		
//		course_seq.push(course);
//		return false;
//	}
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adj_list = getAdjecencyList(numCourses, prerequisites);
        Set<Integer> visited = new HashSet<Integer>();
        boolean[] inStack = new boolean[numCourses];
        Stack<Integer> course_seq = new Stack<Integer>();

        int[] seq = new int[numCourses];
        
        for(int c=0;c<numCourses;c++) {
        	if(!dfs(c, adj_list, visited, course_seq, inStack))
            	return new int[0];
        		
        }
        
        for(int i=0;i<seq.length;i++)
        	seq[i]=course_seq.pop();
        
        return seq;
    }
	
	private boolean dfs(int course, List<List<Integer>> adj_list, Set<Integer> visited, Stack<Integer> course_seq, boolean[] inStack) {
		if(inStack[course])
			return false;
		
		if(visited.contains(course))
            return true;
		
		inStack[course]=true;
        
			
		for(int pre : adj_list.get(course)) {
			if(!dfs(pre, adj_list, visited, course_seq, inStack))
				return false;
			
		}
		inStack[course]=false;
		visited.add(course);
		course_seq.push(course);
		
		return true;
	}
	
	
	
	public List<List<Integer>> getAdjecencyList(int numCourses, int[][] prerequisites){
        List<List<Integer>> adj_list = new ArrayList<>(numCourses);
        for(int i=0;i<numCourses;i++)
            adj_list.add(new ArrayList<Integer>());

        for(int[] pre : prerequisites){
            adj_list.get(pre[1]).add(pre[0]);
        }
        return adj_list;
    }

	public static void main(String[] args) {
		CourseScheduleOrder cso = new CourseScheduleOrder();
// 		int[] res = cso.findOrder(4, new int[][] {{1,0},{2,0},{3,1},{3,2}});
 		int[] res = cso.findOrder(2, new int[][] {{1,0},{0,1}});
//		int[] res = cso.findOrder(2, new int[][] {});
 		System.out.print("[ ");
		for(int n : res)
			System.out.print(n+" ");
		System.out.print("]");

	}

}
