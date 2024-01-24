package prep.leetcode;

public class LongestSubstringRepeatingChars 
{
	public int longestSubString(String str)
	{
		int res=Integer.MIN_VALUE;
		int left=0;
		int right=1;
		
		while(right<str.length())
		{
			if(str.charAt(right)==str.charAt(left))
				res = Math.max(res, right-left+1);
			else
				left=right;
			
			right++;
		}
		
		return res;
	}

	public static void main(String[] args) 
	{	
		LongestSubstringRepeatingChars lss = new LongestSubstringRepeatingChars();
		System.out.println(lss.longestSubString("abbbcddddd"));
	}

}
