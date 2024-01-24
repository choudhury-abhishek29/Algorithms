package prep.leetcode;

public class LongestRepeatingCharacterReplacement 
{
	public static int characterReplacement(String s, int k) 
	{
		int maxLength=0;
		int maxCount=0;
		int left=0;
		int[] charCounts=new int[26];
		
		for(int right=0;right<s.length();right++)
		{
			int currentCharInd = s.charAt(right)-'A';
			charCounts[currentCharInd]++;
			maxCount=Math.max(maxCount, charCounts[currentCharInd]);
			
			while(right-left-maxCount+1 > k)
			{
				charCounts[s.charAt(left)-'A']--;
				left++;
			}
			maxLength=Math.max(maxLength, (right-left)+1);
		}
		
		return maxLength;
        
    }

	public static void main(String[] args)
	{
		System.out.println(characterReplacement("AABABBA",1));

	}

}
