package prep.leetcode;

public class TripsInMinTime {
	public Boolean isTimeEnough(int[] time, long givenTime, int totalTrips)
	{
		long trips=0;
		for(int t : time)
			trips+=givenTime/t;
		return trips>=totalTrips;
	}
	
	public long minimumTime(int[] time, int totalTrips) {
		int maxTime=0;
		for(int t : time)
			maxTime=Math.max(maxTime, t);
		
		long left=1;
		long right=(long)maxTime*totalTrips;
		
		while(left<right)
		{
			long mid = (left+right)/2;
			if(isTimeEnough(time, mid, totalTrips))
				right=mid;
			else
				left=mid+1;
		}
		return left;
    }
	

	public static void main(String[] args) {
		int[] time = new int[] {1,2,3};
		TripsInMinTime timt = new TripsInMinTime();
		System.out.println(timt.minimumTime(time, 5));

	}

}
