package prep.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites){
        List<List<Integer>> adj_list = getAdjecencyList(numCourses, prerequisites);
        List<Integer> seq = new ArrayList<Integer>();
        boolean[] inStack = new boolean[numCourses];
        Set<Integer> visited = new HashSet<Integer>();

        for(int i=0;i<numCourses;i++){
            if(isCyclic(i, adj_list, inStack, visited, seq))
                return false;
        }
        System.out.println(seq);
        return true;
    }

    public boolean isCyclic(int course, List<List<Integer>> adj_list, boolean[] inStack, Set<Integer> visited, List<Integer> seq){
        if(inStack[course])
            return true;
        
        if(visited.contains(course))
            return false;

        inStack[course]=true;
        visited.add(course);
        for(int pre : adj_list.get(course)){
            if(isCyclic(pre, adj_list, inStack, visited, seq))
                return true;
        }

        inStack[course]=false;
        seq.add(course);
        return false;
    }

    public List<List<Integer>> getAdjecencyList(int numCourses, int[][] prerequisites){
        List<List<Integer>> adj_list = new ArrayList<>(numCourses);
        for(int i=0;i<numCourses;i++)
            adj_list.add(new ArrayList<Integer>());

        for(int[] pre : prerequisites){
            adj_list.get(pre[0]).add(pre[1]);
        }
        return adj_list;
    }
	
	public static void main(String[] args)
	{
		CourseSchedule cs = new CourseSchedule();
//		System.out.println(canFinish(5, new int[][] {{1,4},{2,4},{3,1},{3,2}}));
		System.out.println(cs.canFinish(4, new int[][] {{0,1},{1,0},{2,0},{3,1},{3,2}}));
//		System.out.println(cs.canFinish(4, new int[][] {{1,0},{2,0},{3,1},{3,2}}));
//		System.out.println(canFinish(5, new int[][] {{1,4},{4,1}}));
//		System.out.println(canFinish(20, new int[][] {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}));
	}

}
