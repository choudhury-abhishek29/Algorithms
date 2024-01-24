package prep.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class CourseSchedule {
//	BFS Solution
//	public static boolean canFinish(int numCourses, int[][] prerequisites) 
//	{
//		HashMap<Integer, List<Integer>> adj_list =  getAdjecencyList(prerequisites);
//        HashSet<Integer> visited = new HashSet<Integer>();
//        Stack<Integer> course = new Stack<Integer>();
//        if(numCourses==1)
//            return true;
//        
//        int start = prerequisites[0][0];
//        course.push(start);
//        while(!course.isEmpty())
//        {
//            int c1 = course.pop();
//            visited.add(c1);
//            List<Integer> nbr = adj_list.get(c1);
//            if(nbr!=null)
//            {
//                for(Integer p_req : nbr)
//                {
//                    if(visited.contains(p_req))
//                        return false;
//                    else
//                    {
//                        course.add(p_req);
//                        visited.add(p_req);
//                    }
//                }
//            }
//            
//        }
//        return true;
//    }
//	
//	public static HashMap<Integer, List<Integer>> getAdjecencyList(int[][] prerequisites)
//	{
//		HashMap<Integer, List<Integer>> adj_map = new HashMap<Integer, List<Integer>>();
//		for(int[] dep : prerequisites)
//		{
//			if(adj_map.get(dep[0])!=null)
//			{
//				ArrayList<Integer> n = new ArrayList<Integer>() ;
//				n.addAll(adj_map.get(dep[0]));
//				n.add(dep[1]);
//				adj_map.put(dep[0], n);
//			}
//			else
//				adj_map.put(dep[0], Arrays.asList(dep[1]));
//		}
//		return adj_map;
//	}
	

//	DFS Solution
	public boolean canFinish(int numCourses, int[][] prerequisites){
        List<List<Integer>> adj_list = getAdjecencyList(numCourses, prerequisites);
        List<Integer> seq = new ArrayList<Integer>();
        boolean[] inStack = new boolean[numCourses];
        Set<Integer> visited = new HashSet<Integer>();

        for(int i=0;i<numCourses;i++){
            if(dfs(i, adj_list, inStack, visited, seq))
                return false;
        }
        System.out.println(seq);
        return true;
    }

    public boolean dfs(int course, List<List<Integer>> adj_list, boolean[] inStack, Set<Integer> visited, List<Integer> seq){
        if(inStack[course])
            return true;
        
        if(visited.contains(course))
            return false;

        inStack[course]=true;
        visited.add(course);
        for(int pre : adj_list.get(course)){
            if(dfs(pre, adj_list, inStack, visited, seq))
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
            adj_list.get(pre[1]).add(pre[0]);
        }
        return adj_list;
    }
	
	public static void main(String[] args)
	{
		CourseSchedule cs = new CourseSchedule();
//		System.out.println(canFinish(5, new int[][] {{1,4},{2,4},{3,1},{3,2}}));
//		System.out.println(cs.canFinish(5, new int[][] {{1,0},{2,0},{3,1},{3,2}}));
		System.out.println(cs.canFinish(4, new int[][] {{1,0},{2,0},{3,1},{3,2}}));
//		System.out.println(canFinish(5, new int[][] {{1,4},{4,1}}));
//		System.out.println(canFinish(20, new int[][] {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}));
	}

}
