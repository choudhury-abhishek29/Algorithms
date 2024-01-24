package prep.leetcode;

public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
        int sptr = 0;
        int tptr = 0;

        while(sptr < s.length() && tptr<t.length())
        {
            if(s.charAt(sptr) == t.charAt(tptr)) {
                sptr++;
                tptr++;
            }
            else
                tptr++;
        }

        if(sptr == s.length()-1)
            return true;

        return false;
    }

	public static void main(String[] args) {
		IsSubsequence is = new IsSubsequence();
		System.out.println(is.isSubsequence("abc", "ahbgdc"));

	}

}
