package prep.leetcode;

import java.util.Stack;

public class ValidParanthesis {
	public static boolean isValid(String s) {
		if(s.length()%2!=0)
			return false;
		
		Stack<Character> stk = new Stack<Character>();
		
		for(char c : s.toCharArray())
		{
			switch(c)
			{
				case '(':
				case '[':
				case '{':
					stk.add(c);
					break;
				case ')' : 
					if(stk.isEmpty() || stk.pop()!='(')
						return false;
					break;
				case ']' : 
					if(stk.isEmpty() || stk.pop()!='[')
						return false;
					break;
				case '}' : 
					if(stk.isEmpty() || stk.pop()!='{')
						return false;
					break;
			}				
		}
		return stk.isEmpty();
        
    }

	public static void main(String[] args) {
		System.out.println(isValid("()"));

	}

}
