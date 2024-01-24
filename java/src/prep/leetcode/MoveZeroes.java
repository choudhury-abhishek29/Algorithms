package prep.leetcode;

public class MoveZeroes {
	
	public static void moveZeroes(int[] nums) 
    {
         int i=0;
         int j=0;
		
        while(i<nums.length && j<nums.length)
        {
            if(nums[i]!=0)
            {
                nums[j]=nums[i];
                i++;
                j++;
            }
            else
            	i++;
        }
        if(j<nums.length)
        {
            for(;j<nums.length;j++)
                nums[j]=0;
        }
        
        for(int x : nums)
        {
        	System.out.print(x+"\t");
        }
        
        
    }
	
	public static void main(String args[])
	{
		MoveZeroes.moveZeroes(new int[] {0,1,0,3,12});
		
	}

}
