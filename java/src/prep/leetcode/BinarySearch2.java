package prep.leetcode;

public class BinarySearch2 {
	public boolean searchMatrix(int[][] matrix, int target) {
//		305709 ns
//        for(int[] row : matrix){
//            int left = 0;
//            int right = row.length-1;
//            if(row[left]<=target && target<=row[right]){
//                if(row[left]==target || row[right]==target)
//                    return true;
//                
//                
//                while(left<=right) {
//                	int mid = (left+right)/2;
//                	if(row[mid]==target) 
//                        return true;
//                    else if(target<row[mid])
//                        right = mid-1;
//                    else
//                        left = mid+1;
//                }
//            }
//        }
//        
//        return false;
		
		
		int top = 0;
		int bot = matrix.length-1;
		int row = 0;
		while(top<=bot) {
			row = (top+bot)/2;
			
			if(target>matrix[row][matrix[row].length-1])
				top = row+1;
			else if((target<matrix[row][0]))
				bot = row-1;
			else
				break;
		}
		
		  int left = 0;
	      int right = matrix[row].length-1;
          
          while(left<=right) {
          	int mid = (left+right)/2;
          	if(matrix[row][mid]==target) 
                  return true;
              else if(target<matrix[row][mid])
                  right = mid-1;
              else
                  left = mid+1;
          }
      
		return false;
    }

	public static void main(String[] args) {
		BinarySearch2 bst = new BinarySearch2();
		long startTime = System.nanoTime();
		System.out.println(bst.searchMatrix(new int[][] {{-8,-7,-5,-3,-3,-1,1},{2,2,2,3,3,5,7},{8,9,11,11,13,15,17},
														{18,18,18,20,20,20,21},{23,24,26,26,26,27,27},{28,29,29,30,32,32,34}}, 11));
		long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("The program took " + elapsedTime + " nanoseconds to run.");
	}

}
