package prep.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes 
{
	public static void setZeroes(int[][] matrix) 
	{
		int row=matrix.length;
		int col=matrix[0].length;
		List<int[]> pos = new ArrayList<int[]>();
		boolean convertRow=false;
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(matrix[i][j]==0)
				{
					matrix[0][j]=0;
					if(i>0)
						matrix[i][0]=0;
					else
						convertRow=true;
				}
			}
		}
		
		for(int i=1;i<row;i++)
		{
			for(int j=1;j<col;j++)
			{
				if(matrix[i][0]==0 || matrix[0][j]==0)
					matrix[i][j]=0;				
			}
		}
		
		if(matrix[0][0]==0)
			convertCol(0, matrix);
		
		if(convertRow)
			convertRow(0, matrix);
		
		
//		for(int[] p : pos)
//		{
//			matrix = convertRow(p[0], matrix);
//			matrix = convertCol(p[1], matrix);
//		}
		
		
		
		
		
		
		
		
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.print("\n");
		}
		
		
    }
	
	public static int[][] convertRow(int row, int[][] matrix)
	{
		int cols=matrix[0].length;
		for(int i=0;i<cols;i++)
			matrix[row][i]=0;
		
		return matrix;
	}
	
	public static int[][] convertCol(int col, int[][] matrix)
	{
		int rows=matrix.length;
		for(int i=0;i<rows;i++)
			matrix[i][col]=0;
		
		return matrix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] {{0,1,1},
									  {1,1,1},
									  {1,1,0}};
		SetMatrixZeroes.setZeroes(matrix);

	}

}
