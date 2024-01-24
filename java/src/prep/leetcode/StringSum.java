package prep.leetcode;

import java.util.Stack;

public class StringSum {
	public String add(String n1, String n2)
	{
		StringBuffer res = new StringBuffer();
		Stack<Integer> sum = new Stack<Integer>();
		int n1_ptr=n1.length()-1;
		int n2_ptr=n2.length()-1;
		int carry=0;
		
		while(n1_ptr>=0 && n2_ptr>=0)
		{
			int temp = n1.charAt(n1_ptr)-'0'+n2.charAt(n2_ptr)-'0'+carry;
			carry = temp/10;
			sum.push(temp%10);
			n1_ptr--;
			n2_ptr--;
		}
		
		while(n1_ptr>=0)
		{
			int temp=n1.charAt(n1_ptr--)-'0'+carry;
			carry = temp/10;
			sum.push(temp%10);
		}
		
		while(n2_ptr>=0)
		{
			int temp=n2.charAt(n2_ptr--)-'0'+carry;
			carry = temp/10;
			sum.push(temp%10);
		}
		
		if(carry>0)
			sum.push(carry);
		
		while(!sum.isEmpty())
			res.append(sum.pop());
			
		
		return res.toString();
	}

	public static void main(String[] args) {
		String num1="22399";
		String num2="1";
		StringSum ss = new StringSum();
		System.out.println(ss.add(num1, num2));
		
//		for(char c : num1.toCharArray())
//			System.out.println((c-'0')+1);

	}

}
