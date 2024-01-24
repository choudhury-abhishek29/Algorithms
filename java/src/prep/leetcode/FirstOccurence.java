package prep.leetcode;

public class FirstOccurence {
	public int strStr(String haystack, String needle) {
		int len = needle.length();
		int occur=-1;
		for(int i=0;i<haystack.length()-needle.length();i++)
		{
			if(haystack.charAt(i)==needle.charAt(0))
			{
				if(haystack.substring(i,i+len).equalsIgnoreCase(needle))
					return i;
			}
		}

		return occur;
}
	public static void main(String[] args) {
		FirstOccurence fo = new FirstOccurence();
		System.out.println(fo.strStr("sadbutsad", "sad"));
				

	}

}
