package prep.leetcode;

public class RemoveMinimumParanthesis {
	public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;

        for(char c : s.toCharArray())
        {
            if(c=='(')
                open++;
            else if(c==')')
            {
                if(open==0 && c==')')
                    continue;
                open--;
            }
            sb.append(c);
        }

        StringBuffer res = new StringBuffer();
        for(int i=sb.length()-1;i>=0;i--)
        {
            if(sb.charAt(i)=='(' && open-- >0)
                continue;
            res.append(sb.charAt(i));
        }

        return res.reverse().toString();
    }

	public static void main(String[] args) {
		RemoveMinimumParanthesis rmp = new RemoveMinimumParanthesis();
		System.out.println(rmp.minRemoveToMakeValid("a)b(c)d"));

	}

}
