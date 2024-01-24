package prep.leetcode;

public class ValidPalindromeII {
	public boolean validPalindrome(String s) {
		int left=0;
		int right=s.length()-1;
		while(left<=right)
		{
			
			if(s.charAt(right)!=s.charAt(left))
				return helper(s, left+1, right) || helper(s, left, right-1);
			
			left++;
			right--;
			
		}
		return true;
    }
	
	public boolean helper(String s, int left, int right)
	{
		int start = left;
		int end = right;
		
		while(start<=end)
		{
			if(s.charAt(start)!=s.charAt(end))
				return false;
			
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		ValidPalindromeII vpii = new ValidPalindromeII();
		System.out.println(vpii.validPalindrome("raceacar"));

	}

}
