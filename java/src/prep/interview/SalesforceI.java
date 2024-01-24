package prep.interview;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SalesforceI {
	public static String interpolate(int n, List<Integer> instances, List<Float> prices) 
	{
		List<Integer> res = findClosestElements(instances, n);
		HashMap<Integer,Float> hm = new HashMap<>();
		for(int i=0;i<instances.size();++i )
		{
			hm.put(instances.get(i), prices.get(i));			
		}
		int x1= res.get(0);
		int x2 = res.get(1);
		Float y1 = hm.get(x1);
		Float y2 = hm.get(x2);
		Float m = (y2-y1)/(x2-x1);
		Float y = m*(n-x1)+y1;

		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.UP);
		return df.format(y);
	}

	 public static List<Integer> findClosestElements( List<Integer> instances, int x) {
	        // Initialize binary search bounds
		 int k = 2;
        int left = 0;
        int right = instances.size()-k;
        // Binary search against the criteria described
        while (left < right) 
        {
            int mid = (left + right) / 2;
            if (x - instances.get(mid) > instances.get(mid + k) - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        } 
        // Create output in correct format
        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            result.add(instances.get(i));
        }
        return result;
    }
	 
//	public static List<Integer> findClosestElements(List<Integer> instances, int x)
//	 {
//		 List<Integer> sortedArr = new ArrayList<Integer>();
//	        for (int num: instances) {
//	            sortedArr.add(num);
//	        }
//	        
//	        // Sort using custom comparator
//	        Collections.sort(sortedArr, (num1, num2) -> Math.abs(num1 - x) - Math.abs(num2 - x));
//	        
//	        // Only take k elements
//	        sortedArr = sortedArr.subList(0,2);
//	        
//	        // Sort again to have output in ascending order
//	        Collections.sort(sortedArr);
//	        return sortedArr;
//	 }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> instances = new ArrayList<Integer>();
		instances.add(10);
		instances.add(25);
		instances.add(50);
		instances.add(100);
		instances.add(500);
		
		List<Float> prices = new ArrayList<Float>();
		prices.add((float) 2.46);
		prices.add((float) 2.58);
		prices.add((float) 2.00);
		prices.add((float) 2.25);
		prices.add((float) 3.00);
		
		System.out.println(SalesforceI.interpolate(75, instances, prices));
		
		

	}

}
