package prep.leetcode;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
		StringBuffer sb = new StringBuffer();
		
		Stack<String> dirs = new Stack<String>();
		for(String name : path.split("/"))
		{
			if(name.isEmpty() || name.equals("."))
				continue;
			else if(name.equals(".."))
			{
				if(!name.isEmpty())
					dirs.pop();
			}
			else
				dirs.push(name);
		}
		
		for(String entry : dirs)
		{
			sb.append("/");
			sb.append(entry);
		}
		
        return sb.length()==0?"/":sb.toString();
    }
	
	public static void main(String[] args)
	{
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath("/home/opt/mount/.."));
	}
}
