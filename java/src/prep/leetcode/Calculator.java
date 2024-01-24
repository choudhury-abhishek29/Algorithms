package prep.leetcode;

import java.util.Stack;

public class Calculator 
{
	public int calculate(String s) {
		int sign=1;
		int sum=0;
		Stack<Integer> stk = new Stack<Integer>();
		
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)>='0' && s.charAt(i)<='9')
			{
				int num=0;
				while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9')
				{
					num = num*10+s.charAt(i)-'0';
					i++;
				}
				sum+=num*sign;
				i--;
			}
			
			else if(s.charAt(i)=='+')
				sign = 1;
			
			else if(s.charAt(i)=='-')
				sign = -1;
			
			else if(s.charAt(i)=='(')
			{
				stk.push(sum);
				stk.push(sign);
				sum=0;
				sign=1;
			}
			
			else if(s.charAt(i)==')')
			{
				sum=stk.pop()*sum;
				sum+=stk.pop();
			}
		}
        return sum;
    }
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		System.out.println(c.calculate("100+(4+5+2)-3+(6+8)"));

	}

}
