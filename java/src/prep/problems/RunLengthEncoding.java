package prep.problems;

import java.util.HashMap;
import java.util.Map;

public class RunLengthEncoding {
	private static String runLengthEncode(String str)
	{
		HashMap<String, Integer> charCount = new HashMap<String, Integer>();
		StringBuffer strb = new StringBuffer();
		
		for(int i=0;i<str.length();i++)
		{
			if(charCount.containsKey(String.valueOf(str.charAt(i))))
			{
				int curCount=charCount.get(String.valueOf(str.charAt(i)));
				charCount.put(String.valueOf(str.charAt(i)), ++curCount);
			}
			else
				charCount.put(String.valueOf(str.charAt(i)), 1);
		}
		
		for(Map.Entry<String, Integer> entry : charCount.entrySet())
		{
			strb.append(entry.getKey());
			strb.append(entry.getValue());			
		}
		
		return strb.toString();
	}
	
	public static void main(String args[])
	{
		String str = "aaaaabbccdddda";
		System.out.println(runLengthEncode(str));
	}

}
