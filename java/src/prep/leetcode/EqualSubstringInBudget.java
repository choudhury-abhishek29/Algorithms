package prep.leetcode;

public class EqualSubstringInBudget {
	public int equalSubstring(String s, String t, int maxCost) {
		int cost=0;
        int left=0;
        int res=-1;
        for(int right=0; right<s.length();right++) {
        	cost+=Math.abs(s.charAt(right)-t.charAt(right));
        	while(cost>maxCost) {
        		cost-=Math.abs(s.charAt(left)-t.charAt(left));
        		left++;
        	}

            res = Math.max(res, right-left+1);
        }
        
        return res;
    }

	public static void main(String[] args) {
		EqualSubstringInBudget es = new EqualSubstringInBudget();
//		System.out.println(es.equalSubstring("abcd", "bcdf", 3));
//		System.out.println(es.equalSubstring("abcd", "cdef", 3));
//		System.out.println(es.equalSubstring("abcd", "acde", 0));
		System.out.println(es.equalSubstring("krrgw", "zjxss", 19));

	}

}
