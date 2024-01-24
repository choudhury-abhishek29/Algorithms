package prep.leetcode;

import java.util.Stack;

public class ReverseKCharacters {
	public String reverseStr(String s, int k) {
        Stack<Character> stk = new Stack<Character>();
        StringBuffer sb = new StringBuffer();
        boolean skip=false;
        int i=0;
        while(i<s.length())
        {
            if(!skip)
                stk.push(s.charAt(i++));
            else
            {
                while(!stk.isEmpty())
                    sb.append(stk.pop());
                sb.append(s.charAt(i++));
            }
            if(i%k==0) skip = !skip;
//            i++;
            
            
        }
        
        if(k>=s.length() || !stk.isEmpty())
        {
        	while(!stk.isEmpty())
        		sb.append(stk.pop());
        }
        
        return sb.toString();
    }

	public static void main(String[] args) {
		ReverseKCharacters rkc = new ReverseKCharacters();
		System.out.println(rkc.reverseStr("abcdefg", 1));

	}

}
