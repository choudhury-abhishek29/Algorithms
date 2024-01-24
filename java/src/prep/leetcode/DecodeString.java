package prep.leetcode;

import java.util.Stack;

public class DecodeString {
	
	public String decodeString(String s) {
        Stack<Integer> count_stack = new Stack<Integer>();
        Stack<StringBuilder> string_stack = new Stack<StringBuilder>();
        int num=0;
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray())
        {
        	if('0'<=c && c<='9')
        		num = num*10+c-'0';
        	else if(c == '[')
        	{
        		string_stack.push(sb);
        		sb = new StringBuilder();
        		count_stack.push(num);
        		num=0;
        	}
        	else if(c == ']')
        	{
        		StringBuilder temp = sb;
        		sb = string_stack.pop();
        		int count = count_stack.pop();
        		for(int i=0;i<count;i++)
        			sb.append(temp);
        	}
        	else
        	{
        		sb.append(c);
        		
        	}
        }
        return sb.toString();
    }

	public static void main(String[] args) 
	{
		DecodeString ds = new DecodeString();
		String decode = ds.decodeString("a2[b3[c]]");
		System.out.println(decode);
		

	}

}
