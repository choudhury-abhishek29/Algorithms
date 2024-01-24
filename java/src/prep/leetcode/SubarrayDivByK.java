package prep.leetcode;

import java.util.HashMap;

public class SubarrayDivByK {
	public int subarraysDivByK(int[] nums, int k) {
	       int sum=0,cnt=0;
	       HashMap<Integer,Integer>hm=new HashMap<>();
	       hm.put(0,1);
	       for(int i=0;i<nums.length;i++){
	           sum+=nums[i];

	           int remainder=sum%k;

	           if(remainder<0){
	               remainder+=k;
	           }

	           if(hm.containsKey(remainder)){
	               cnt+=hm.get(remainder);
	           }
	           hm.put(remainder,hm.getOrDefault(remainder,0)+1);
	       }
	    return cnt;
	    }

	public static void main(String[] args) {
		SubarrayDivByK sdk = new SubarrayDivByK();
		System.out.println(sdk.subarraysDivByK(new int[] {4,5,0,-2,-3,1}, 5));

	}

}
