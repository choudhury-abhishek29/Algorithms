package prep.leetcode;

public class ValidPalindrome {
	public boolean isPalindrome(String s) 
	{
		StringBuffer sb = new StringBuffer();
		for(char c : s.toCharArray())
		{
			if(Character.isLetter(c) || Character.isDigit(c))
				sb.append(Character.toLowerCase(c));
		}
			
		
		int left=0;
		int right=sb.length()-1;
		
		while(left<right)
		{
			
			if(sb.charAt(right)!=sb.charAt(left))
				return false;
			
			left++;
			right--;
			
		}
		return true;
    }

	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));

	}

}
