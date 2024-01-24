package prep.interview;

public class QiaBinarySearch {
	
	private boolean binSearch(int[] arr, int num) {
		int left = 0;
		int right = arr.length-1;
		
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(num < arr[mid])
				right = mid-1;
			else if(num > arr[mid])
				left = mid+1;
			else
				return true;
		}
	
		return false;
	}
	

	public static void main(String[] args) {
		QiaBinarySearch qbs = new QiaBinarySearch();
		int[] arr = new int[] {-1,2,7,9,14,17,19,25,30};
		System.out.println(qbs.binSearch(arr, -1));
	}

}
