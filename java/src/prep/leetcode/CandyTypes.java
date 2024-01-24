package prep.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CandyTypes {
	public int distributeCandies(int[] candyType) 
	{
		int maxVariety=0;
		Set<Integer> uniqueCandies = new HashSet<Integer>();
		for(int candy : candyType)
			uniqueCandies.add(candy);
		
//		if(uniqueCandies.size()<=candyType.length/2)
//			maxVariety=uniqueCandies.size();
//		else
			maxVariety=Math.min(uniqueCandies.size(), candyType.length / 2);
		
		
        return maxVariety;
    }

	public static void main(String[] args) {
		 CandyTypes ct = new CandyTypes();
		 System.out.println(ct.distributeCandies(new int[] {1,1,2,3,4,5}));

	}

}
