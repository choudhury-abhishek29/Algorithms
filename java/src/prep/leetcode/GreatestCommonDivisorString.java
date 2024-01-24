package prep.leetcode;

public class GreatestCommonDivisorString 
{	
	public String gcdOfStrings(String str1, String str2)
	{
//		if(!(str1+str2).equals(str2+str1))
//			return "";
//		else if(str1.equals(str2))
//			return str1;
//		else if(str1.length() > str2.length())
//			return gcdOfStrings(str1.substring(str2.length()),str2);
//		else
//			return gcdOfStrings(str2.substring(str1.length()),str1);
		
		if(str2.length() > str1.length())
			return gcdOfStrings(str2, str1);
		
		if(str2.equals(str1))
			return str1;
		
		if(str1.startsWith(str2))
			return gcdOfStrings(str1.substring(str2.length()), str2);
		
		return "";
	}

	public static void main(String[] args) 
	{
		GreatestCommonDivisorString gcds = new GreatestCommonDivisorString();
		System.out.println(gcds.gcdOfStrings("ABABAB", "ABAB"));
	

	}

}
 