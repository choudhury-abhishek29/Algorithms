package prep.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
	public List<String> generateParanthesis(int n)
	{
		List<String> res = new ArrayList<String>();
		backtrack(res, "", 0, 0, n);
		
		return res;
	}
	
	public void backtrack(List<String> out, String curr_string, int open, int close, int max)
	{
		if(curr_string.length()==max*2)
			out.add(curr_string);
		
		if(open<max)
			backtrack(out, curr_string+"(", open+1, close, max);
		
		if(close<open)
			backtrack(out, curr_string+")", open, close+1, max);
		
		
		
	}
	
	public static void main(String[] args)
	{
		GenerateParanthesis gp = new GenerateParanthesis();
		gp.generateParanthesis(2).stream()
			.forEach(x->System.out.println(x));
	}

}
