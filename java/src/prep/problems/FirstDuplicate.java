package prep.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FirstDuplicate 
{
	private static int findDuplicate(int[] array)
	{
		int occ=-1;
//		using hashmap
//		HashMap<Integer,Integer>occMap = new HashMap<Integer,Integer>();
//		for(int i : array)
//		{
//			if(occMap.containsKey(i))
//			{
//				if(occMap.get(i)==1)
//					return i;
//			}
//			else
//			{
//				occMap.put(i, 1);
//			}
//		}
		
//		using hashset
//		Set<Integer> occSet = new HashSet<Integer>();
//		for(int i : array)
//		{
//			if(occSet.contains(i))
//				return i;
//			else
//				occSet.add(i);
//		}
		
//		turn negative
		for(int i : array)
		{
			int val = array[Math.abs(i)-1];
			if(val<0)
				return Math.abs(val);
			else
			{
				array[Math.abs(i)-1]=-1*val;
			}
		}
		
		
		return occ;
	}
	
	public static void main(String args[])
	{
//		int[] arr = {2,1,3,5,3,2};
//		int[] arr = {1,2,1,2,3,3};
		int[] arr = {1,2,3,4,5,6};
		System.out.println(findDuplicate(arr));
		
	}

}
