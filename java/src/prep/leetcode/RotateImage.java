package prep.leetcode;

public class RotateImage {
	
	public void rotate(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		//transpose
		for(int i=0;i<rows;i++)
		{
			for(int j=i;j<cols;j++)
			{
				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}
		}
		
		//swap columns
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<(cols/2);j++)
			{
				int temp=matrix[i][j];
				matrix[i][j]=matrix[i][cols-1-j];
				matrix[i][cols-1-j]=temp;
			}
		}
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				System.out.print(" "+matrix[i][j]+" ");
			}
			System.out.print("\n");
		}
		
		
        
    }

	public static void main(String[] args) 
	{
		
		RotateImage ri = new RotateImage();
		int[][] mat = new int[][] {
									{1,2,3},
									{4,5,6},
									{7,8,9}
								};
								
		ri.rotate(mat);
		

	}

}
