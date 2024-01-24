package prep.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumTime 
{
	int[] perms = new int[] {1234,2134,3124,1324,2314,3214,3241,2341,4321,3421,2431,4231,4132,1432,3412,4312,1342,3142,2143,1243,4213,2413,1423,4123};
	public String getMaxTime(int[] digits)
	{
		int timeMax=0;
		int mindiff=Integer.MAX_VALUE;
//		List<Integer> digits_list = new ArrayList<Integer>();
//		for(int d : digits)
//			digits_list.add(d);
//		
//		
//		return timeMax;
		
		Arrays.sort(digits); 
        String result = "";

        for (int h = 23; h >= 0; h--) {
            for (int m = 59; m >= 0; m--) {
                int[] dig = { h / 10, h % 10, m / 10, m % 10 };
                Arrays.sort(dig); 

                if (Arrays.equals(digits, dig)) {
                    result = String.format("%02d:%02d", h, m);
                    return result;
                }
            }
        }

        return result;
		
//		for(int n : perms)
//		{
//			int temp = 2359-n;
//			if(temp>0)
//			{
//				if(temp<mindiff)
//				{
//					mindiff=temp;
//					timeMax=n;
//				}
//			}	
//		}
//		
//		String res = String.valueOf(timeMax);
//		return res.substring(0, 2)+":"+res.substring(2);
		
	}
	
	public static void main(String[] args)
	{
		MaximumTime mt = new MaximumTime();
		System.out.println(mt.getMaxTime(new int[] {1,2,3,4}));
		
	}

}
