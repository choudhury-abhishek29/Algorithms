package prep.leetcode;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
        int top = 0;
        int bot = n-1;
        int left = 0;
        int right = n-1;
        int[][] grid = new int[n][n];
        int count=1;
        
        while(top<=bot && left<=right && count<=n*n){
            for(int i=left;i<=right;i++)
                grid[top][i]=count++;
            top++;
            
            for(int j=top;j<=bot;j++)
                grid[j][right]=count++;
            right--;
            
            if(left<=right){
                for(int i=right;i>=left;i--)
                    grid[bot][i]=count++;
            }
            bot--;
            
            if(top<=bot){
                for(int j=bot;j>=top;j--)
                    grid[j][left]=count++;
            }
            left++;
        }
        return grid;
    }

	public static void main(String[] args) {
		SpiralMatrixII sp = new SpiralMatrixII();
		int[][] grid = sp.generateMatrix(4);
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				System.out.print("\t"+grid[i][j]+"\t");
			}
			System.out.println("");
		}

	}

}
