package prep.leetcode;


public class MakeRopeColorful {
	public int minCost(String colors, int[] neededTime) {
		int minCost=0;
		char[] clrs = colors.toCharArray();
		
		int left=0;
		int right=1;
		
		while(right<clrs.length)
		{
			if(clrs[left]==clrs[right])
			{	
				minCost+=Math.min(neededTime[left], neededTime[right]);
				neededTime[right]=Math.max(neededTime[right], neededTime[left]);
			}
			
			right++;
			left++;
		}
		
		
        return minCost;
    }

	public static void main(String[] args) {
		MakeRopeColorful mrc = new MakeRopeColorful();
		System.out.println(mrc.minCost("aaabbbabbbb", new int[] {3,5,10,7,5,3,5,5,4,8,1}));

	}

}
