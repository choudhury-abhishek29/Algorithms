package prep.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/*
 * 10
2
3
5
123
abc
12
10
jkl
xzy
12
10
123
-1
200
99
88
77
23
abc
rts
45
55
67
87
87
45
*/
public class Qiagen {

	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = null;
//		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();		
		List<Integer> nl = new ArrayList<Integer>();
		int max = Integer.MIN_VALUE;
		try {
			br = new BufferedReader(new FileReader("/Users/abhishek/Documents/qiagen.txt"));
		    String line = br.readLine();
		    while (line != null) {
		    	try {
		    		int n = Integer.parseInt(line);
		    		if(n>0) {
		    			max = Math.max(max, n);
		    			nl.add(n);	// using this list to initially store the numbers
//		    			tm.put(n, tm.getOrDefault(n, 0)+1);	//the treemap will take care of all uniques and frequencies
		    		}
		    	}
		    	catch(NumberFormatException e) {
		    	}
		    	line = br.readLine();
		    }
		    
		    int[] nums = new int[max];
		    for(int n : nl) {
	    		nums[n-1]++;
		    }
		  
		    
//		    for(Map.Entry<Integer, Integer> entry : tm.entrySet()) {
//		    	System.out.println(entry.getKey()+" : "+entry.getValue());
//		    }
		    
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			br.close();
		}

	}
	
//	Marqeta 

}
