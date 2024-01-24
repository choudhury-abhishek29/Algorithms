package prep.leetcode;

import java.util.Stack;

public class LongestAbsPath 
{
	 public int lengthLongestPath(String input) {
	        int maxLength=0;
	        Stack<Integer> stk = new Stack<Integer>();
	        stk.push(0);
	        String[] dirs = input.split("\\n");
	        
	        for(String name : dirs)
	        {
	        	int level = name.lastIndexOf('\t')+1;
	        	
	        	while(stk.size()-1>level)
	        		stk.pop();
	        	
	        	stk.push(stk.peek()+(name.length()-level)+1);
	        	
	        	if(name.contains("."))
	        		maxLength = Math.max(maxLength, stk.peek()-1);
	        	
	        }  
	        
	        
	    return maxLength;
	 }


	public static void main(String[] args) {
		LongestAbsPath lap = new LongestAbsPath();
		System.out.println(lap.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));

	}

}
