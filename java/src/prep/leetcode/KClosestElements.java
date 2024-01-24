package prep.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KClosestElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> result = new ArrayList<Integer>();
		int left = 0;
		int right = arr.length-k;
		while(left<right)
		{
			int mid = (left+right)/2;
			
			if(x-arr[mid] > arr[mid+k]-x)
				left = mid+1;
			else
				right = mid;
		}
		
		for(int i=left;i<left+k;i++)
			result.add(arr[i]);
		
		return result;
	}

	public static void main(String[] args) {
		KClosestElements kc = new KClosestElements();
		for(int n : kc.findClosestElements(new int[] {1,2,4,5,6}, 2, 3))
			System.out.println(n);

	}

}
