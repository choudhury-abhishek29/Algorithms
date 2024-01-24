package prep.leetcode;

import java.util.Stack;

public class CalculatorII {
	public int calculate(String str)
	{
		if(str==null || str.length()==0) return 0;
		int res=0;
		Stack<Integer> stk = new Stack<>();
		char opr='+';
		
		for(int i=0;i<str.length();i++)
		{
			char curr_char = str.charAt(i);
			if(Character.isDigit(curr_char))
			{
				StringBuffer sb = new StringBuffer();
				while(i<str.length() && Character.isDigit(str.charAt(i)))
					sb.append(str.charAt(i++));
				i--;
				
				if(opr=='*')
					stk.push(Integer.valueOf(sb.toString())*stk.pop());
				else if(opr=='/')
					stk.push(stk.pop()/Integer.valueOf(sb.toString()));
				else if(opr=='-')
					stk.push(-1*Integer.valueOf(sb.toString()));
				else
					stk.push(Integer.valueOf(sb.toString()));

				opr='+';
			}
			
			if(curr_char!=' ')
			{
				switch(curr_char)
				{
					case '/': opr='/';
						break;
					case '*': opr='*';
						break;
					case '-': opr='-';
					break;
				}
			}
		}
		
		while(!stk.isEmpty())
			res+=stk.pop();
		
		return res;
	}
	
	

	public static void main(String[] args) {
		CalculatorII c2 = new CalculatorII();
		System.out.println(c2.calculate("3-1+50 / 5"));

	}

}
