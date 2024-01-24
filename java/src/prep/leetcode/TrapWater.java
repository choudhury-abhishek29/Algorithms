package prep.leetcode;

public class TrapWater {
	public int totalWaterTrapped(int[] height)
	{
		int n = height.length;
        int left=0;
        int right=n-1;
        int left_max=0;
        int right_max=0;
        int water=0;
        
		while(left<right)
        {
            if(height[left]<=height[right])
            {
                if(height[left]>left_max)
                    left_max = height[left];
                else
                    water+=left_max-height[left];
                left++;
            }
            else
            {
                if(height[right]>right_max)
                    right_max = height[right];
                else
                    water+=right_max-height[right];
                right--;
            }
        }
        return water;
		
	}
	
	public int maximumWaterTrapped(int[] height)
	{
		int n = height.length;
		int left=0;
		int right=n-1;
		int maxWater = 0;
		
		while(left<right)
		{
			if(height[left]<height[right])
			{
				maxWater = Math.max(maxWater, height[left]*(right-left));
				left++;
			}
			else
			{
				maxWater = Math.max(maxWater, height[right]*(right-left));
				right--;
			}
		}
		return maxWater;
	}

	public static void main(String[] args) {
		TrapWater tw = new TrapWater();
		System.out.println(tw.totalWaterTrapped(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println(tw.maximumWaterTrapped(new int[] {1,8,6,2,5,4,8,3,7}));

	}

}
