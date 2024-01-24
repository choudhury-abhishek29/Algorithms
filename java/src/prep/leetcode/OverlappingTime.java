package prep.leetcode;

import java.util.Date;

public class OverlappingTime {
	public boolean isOverlapping(Date[] range1, Date[] range2)
	{
		if(range1[1].after(range2[0]) && range1[0].before(range2[1]))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d1 = new Date(2023,05,25);
		Date d2 = new Date(2023,05,29);
		Date d3 = new Date(2023,06,02);
		Date d4 = new Date(2023,06,11);
		Date d5 = new Date(2023,06,15);
		Date d6 = new Date(2023,06,16);
		
		Date[] range1 = new Date[] {d1, d3};
		Date[] range2 = new Date[] {d2, d4};
		Date[] range3 = new Date[] {d3, d5};
		Date[] range4 = new Date[] {d4, d6};
		
		OverlappingTime ot = new OverlappingTime();
		System.out.println(ot.isOverlapping(range1, range2));
		System.out.println(ot.isOverlapping(range2, range3));
		System.out.println(ot.isOverlapping(range1, range4));

	}

}
