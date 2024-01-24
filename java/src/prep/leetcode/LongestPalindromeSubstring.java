package prep.leetcode;

public class LongestPalindromeSubstring {
	public String longestPalindrome(String s) {
        int left=0;
        int right=0;
        for(int i=0;i<s.length();i++)
        {
            int len1 = expandFromMiddle(s,i,i);
            int len2 = expandFromMiddle(s,i,i+1);
            int len=Math.max(len1,len2);
            
            if(len>(right-left))
            {
                left = i-(len-1)/2;
                right = i+len/2;
            }
        }
        
        return s.substring(left, right+1);
    }
    
    public int expandFromMiddle(String s, int left, int right)
    {
        if(s==null || s.length()==0) return 0;
        
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            right++;
            left--;
        }
        
        return right-left-1;
    }

	public static void main(String[] args) {
		LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
		System.out.println(lps.longestPalindrome("asjdhbbccdedccbblkajsdl"));

	}

}
