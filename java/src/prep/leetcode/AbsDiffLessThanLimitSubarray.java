package prep.leetcode;

import java.util.PriorityQueue;

public class AbsDiffLessThanLimitSubarray {
	public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        int a=0,b=0;
        int res = 0;
        while(b<nums.length){
            min.add(nums[b]);
            max.add(nums[b]);
            while(Math.abs(max.peek()-min.peek()) >limit){
                min.remove(nums[a]);
                max.remove(nums[a]);
                a++;
            }
            res = Math.max(b-a+1,res);
            b++;
        }
        return res;
    }

	public static void main(String[] args) {
//		AbsDiffLessThanLimitSubarray abs = new AbsDiffLessThanLimitSubarray();
//		System.out.println(abs.longestSubarray(new int[] {10,1,2,4,7,2}, 5));
		int n=15;
		for(int i=1;i<=n;i++)
        {
            if(n%3==0 && n%5==0)
                System.out.println("FizzBuzz");
            else if(n%3==0 && n%5!=0)
                System.out.println("Fizz");
            else if(n%3!=0 && n%5==0)
                System.out.println("Buzz");
            else
                System.out.println(n);
        }

	}

}
