package prep.leetcode;

public class GreatestCommonDivisorInteger {
	public int gcdOfIntegers(int n1, int n2) {
		while(n1!=n2) {
			if(n1>n2)
				n1=n1-n2;
			else
				n2=n2-n1;
		}
		return n1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		GreatestCommonDivisorInteger gcdi = new GreatestCommonDivisorInteger();
//		System.out.println(gcdi.gcdOfIntegers(48, 40));
		
		int price = 3705;
        int discount = 20;
        int res = (int) (price-(((float)(discount)/100)*price));
        System.out.println(res);
        
        float x = ((float)(discount)/100);
        System.out.println(x);

	}

}
