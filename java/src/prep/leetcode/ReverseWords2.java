package prep.leetcode;

public class ReverseWords2 
{
	public static String reverseWords(String s) 
	{
//		String[] splitted = s.split(" ");
		StringBuffer sb = new StringBuffer();
		StringBuilder word = new StringBuilder();
//		for(int i=0;i<splitted.length;i++)
//		{
//			sb.append(rev(splitted[i])+" ");
//		}
		
//		return sb.toString().trim();
		
		for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            } else {
                sb.append(word.reverse());
                sb.append(" ");
                word.setLength(0);
            }
        }
		
		sb.append(word.reverse());
        return sb.toString();
		
        
    }
	
	public static String rev(String s)
	{
		char[] chars = s.toCharArray();
		int i=0;
		int j=chars.length-1;
		while(i<j)
		{
			char temp = chars[i];
			chars[i]=chars[j];
			chars[j]=temp;
			i++;
			j--;
		}
		
		return new String(chars);
	}
	
	public static void main(String args[])
	{
		System.out.println(ReverseWords2.reverseWords("Let's take LeetCode contest"));
	}

}
