package prep.leetcode;

public class MinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
        if(nums.length==0) return -1;
        if(nums.length==1) return nums[0];

        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            
            if(mid>0 && nums[mid]<nums[mid-1])
            	return nums[mid];
            else if(nums[left]<=nums[mid] && nums[mid]>nums[right])
            	left = mid+1;
            else
            	right = mid-1;
           
        }
        return nums[left];
    }

	public static void main(String[] args) {
		MinimumInRotatedSortedArray mrsa = new MinimumInRotatedSortedArray();
		System.out.println(mrsa.findMin(new int[] {3,4,5,1,2 }));

	}

}
 