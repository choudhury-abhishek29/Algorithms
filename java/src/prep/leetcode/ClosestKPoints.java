package prep.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestKPoints {
	public int[][] kClosest(int[][] points, int k) 
	{
       int[][] res = new int[k][2];
       
       PriorityQueue<int[]> point_list = new PriorityQueue<int[]>((x,y)->((x[0]*x[0]+x[1]*x[1])-(y[0]*y[0]+y[1]*y[1])));
       
       for(int[] point : points)
       {
//    	   System.out.println("offering point : ["+point[0]+"]["+point[1]+"]");
    	   point_list.offer(point);
       }
    	   
       
       for(int i=0;i<k;i++)
    	   res[i]=point_list.poll();
       
       
       return res;
    }

	public static void main(String[] args) 
	{
		ClosestKPoints kp = new ClosestKPoints();
		int[][] points = new int[][] {{1,1},{2,2},{3,3}};
		int[][] cp = kp.kClosest(points, 2);
		for(int[] p : cp)
			System.out.println(p[0]+","+p[1]);

	}

}
