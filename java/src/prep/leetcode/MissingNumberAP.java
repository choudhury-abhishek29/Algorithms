package prep.leetcode;

public class MissingNumberAP 
{
	public static int findMissingNumber(int[] arr)
	{
		int i=arr[0];
		int diff = (arr[arr.length-1]-arr[0])/arr.length;
		for(int x : arr)
		{
			if(x!=i)
				return i;
			else
				i+=diff;
		}
		
		return -1;
		
	}
	
	public static void main(String args[])
	{
		int[] arr = new int[] {1,3,5, 9};
		System.out.println(MissingNumberAP.findMissingNumber(arr));
	}

}
