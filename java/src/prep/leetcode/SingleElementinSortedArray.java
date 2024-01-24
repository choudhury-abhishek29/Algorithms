package prep.leetcode;

public class SingleElementinSortedArray {
	public int singleNonDuplicate(int[] nums)
	{
		int low=0;
		int high=nums.length-1;
		
		while(low<high)
		{
			int mid=low+(high-low)/2;
			Boolean halvesAreEven = (high-mid)%2==0;
			
			if(nums[mid]==nums[mid+1])
			{
				if(halvesAreEven)
					low=mid+2;
				else
					high=mid-1;
				
			}
			else if(nums[mid-1]==nums[mid])
			{
				if(halvesAreEven)
					high=mid-2;
				else
					low=mid+1;
			}
			else
				return nums[mid];
		}
		return nums[low];
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,1,2,2,3,3,4,8,8};
		SingleElementinSortedArray se = new SingleElementinSortedArray();
		System.out.println(se.singleNonDuplicate(nums));

	}

}
