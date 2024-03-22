package prep.interview;

public class Fractal {
	//3sum
	/*
	Given an array arr[] of size n and an integer sum, output YES if there’s a triplet in the array which sums up to the given sum, and NO otherwise.
	Input: array = {12, 3, 4, 1, 6, 9}, sum = 24; 
	Output: YES 
	Explanation: There is a triplet (12, 3 and 9) present in the array whose sum is 24. 

	Input: array = {1, 2, 3, 4, 5}, sum = 19 
	Output: NO
	Explanation: There is a no triplet present in the array whose sum is 19.
	*/

//	nlog(n)+n

	public List<List<Integer>> isTripletThere(int[] arr, int sum){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(arr);
	  for(int i=0;i<arr.length-2;i++){
	  	int target = sum-arr[i];
	    int left = i+1;
	    int right = arr.length-1;
	    
	    while(left < right){
	    	int s = arr[left] + arr[right];
	    	if(s<target)
	      	left++;
	      else if(s>target)
	      	right--;
	      else
	      	result.add(Arrays.asList(arr[i], arr[left], arr[right]));
	      	
	    }
	    
	    return result;
	  }
	}
}
