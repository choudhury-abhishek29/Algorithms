package prep.sort;

public class MergeSortDemo {
	
	public static int[] mergeSort(int[] array)
	{
		if(array.length<=1)
			return array;
		
		int mid = array.length/2;
		int[] left = new int[mid];
		int[] right;
		
		//finding a proper mid for right side
		if(array.length%2==0)
			right=new int[mid];
		else
			right=new int[mid+1];
		
		//populating left and right arrays
		for(int i=0;i<mid;i++)
			left[i]=array[i];
		
		for(int j=0;j<right.length;j++)
			right[j]=array[mid+j];
		
		int[] result = new int[array.length];
		left=mergeSort(left);
		right=mergeSort(right);
		
		result = merge(left, right);
		
		return result;
		
	}
	
	private static int[] merge(int[] left, int[] right)
	{
		int[] result = new int[left.length+right.length];
		int leftPtr=0, rightPtr=0, resPtr=0;
		
		while(leftPtr<left.length || rightPtr<right.length)
		{
			if(leftPtr<left.length && rightPtr<right.length)
			{
				if(left[leftPtr]<right[rightPtr])
					result[resPtr++]=left[leftPtr++];
				else
					result[resPtr++]=right[rightPtr++];
			}
			else if(leftPtr<left.length)
				result[resPtr++]=left[leftPtr++];
			else if(rightPtr<right.length)
				result[resPtr++]=right[rightPtr++];
			
		}
		
		return result;		
	}
	
	private static void printArray(int[] arr)
	{
		for(int i : arr)
			System.out.print(i+" ");
		System.out.println("");
	}
	
	public static void main(String args[])
	{
		int[] arr = {6,5,4,3,2,1};
		printArray(arr);
		arr = mergeSort(arr);
		printArray(arr);
	}

}
