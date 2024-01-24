package prep.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class EatBananas {
	public int minEatingSpeed(int[] piles, int h) {
		int left=1;
		int right=Arrays.stream(piles).max().getAsInt();
		int res=right;
		while(left<=right) {
			int k = (left+right)/2;
			int totalHours = 0;
			for(int n : piles) {
				totalHours+=Math.ceil((double)n/k);
			}
			
			if(totalHours<=h) {
				res = Math.min(k, res);
				right = k-1;
			}
			else if(totalHours>h)
				left = k+1;
		}
		
        return res;
    }

	public static void main(String[] args) {
		EatBananas eb = new EatBananas();
		System.out.println(eb.minEatingSpeed(new int[] {3,6,7,11}, 8));
//		System.out.println(Math.ceil((double)8/3));
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		

	}

}
