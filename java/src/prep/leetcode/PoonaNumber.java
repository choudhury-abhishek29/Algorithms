package prep.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PoonaNumber {
	public boolean isPoonaNumber(int n, String number) {
		number = number.toLowerCase();
		int sum=0;
		for(char c : number.toCharArray()) {
			if(c!=' ')
				sum+=c-'a'+1;
		}
		if(n==sum)
			System.out.println(n+":"+sum);
		
		return n==sum;
	}
	
	private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num); 
    }
    
    private String helper(int num) {
        String result = new String();
        if (num < 10) 
        	result = belowTen[num];
        else if (num < 20) 
        	result = belowTwenty[num -10];
        else if (num < 100) 
        	result = belowHundred[num/10] + " " + helper(num % 10);
        else if (num < 1000) 
        	result = helper(num/100) + " Hundred " +  helper(num % 100);
        else if (num < 1000000) 
        	result = helper(num/1000) + " Thousand " +  helper(num % 1000);
        else if (num < 1000000000) 
        	result = helper(num/1000000) + " Million " +  helper(num % 1000000);
        else 
        	result = helper(num/1000000000) + " Billion " + helper(num % 1000000000);
        
        
        return result.trim();
    }
	
	public static void main(String[] args) {
		PoonaNumber pn = new PoonaNumber();
//		System.out.println(pn.numberToWords(100));
		
//		for(int i=0;i<=100;i++) {
//			pn.isPoonaNumber(i, pn.numberToWords(i));
//		}
		
		int num=21123;
		System.out.println(pn.isPoonaNumber(num, pn.numberToWords(num)));
	}
}
