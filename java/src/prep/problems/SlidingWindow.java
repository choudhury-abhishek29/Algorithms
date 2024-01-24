package prep.problems;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindow {
	public static long carParkingRoof(List<Long> cars, int k) 
    {
        if(cars.size()==0 || k<0)
            return 0;
        cars.sort(null);
        long sol = Long.MAX_VALUE;
        
        for(int start=0, end=k-1;end<cars.size();start++,end++)
        {
        	System.out.println("start : "+start);
        	System.out.println("end : "+end);
            sol=Math.min(sol,cars.get(end)-cars.get(start));
        }
        
        return sol+1;
    }
	
	public static void main(String args[])
	{
		List<Long> cars = new ArrayList<Long>();
		cars.add((long)6);
		cars.add((long)2);
		cars.add((long)12);
		cars.add((long)7);
		System.out.println(SlidingWindow.carParkingRoof(cars, 3));
	}

}
