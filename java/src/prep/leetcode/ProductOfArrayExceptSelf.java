package prep.leetcode;

public class ProductOfArrayExceptSelf {
	public static int[] productExceptSelf(int[] nums) {
		int N = nums.length;
		int[] fp = new int[N];
		
		fp[0]=1;
		int rp=1;
		
		for(int i=1;i<N;i++)
		{
			fp[i]=nums[i-1]*fp[i-1];
		}
		
		for(int i=N-1;i>=0;i--)
		{
			fp[i] = fp[i] * rp;
			rp = rp * nums[i];
		}
		
		return fp;
    }
	
	public static void main(String[] args) {
		int[] res = productExceptSelf(new int[] {1,2,3,4});
		for(int x : res)
			System.out.println(x);
	}

}
