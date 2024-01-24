package prep.leetcode;

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		int rows = matrix.length; 
		int cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        // for convenience, we add an extra all zero column and row
        // outside of the actual dp table, to simpify the transition
        for (int i = 1; i <= rows; i++) 
        {
            for (int j = 1; j <= cols; j++) 
            {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }

	public static void main(String[] args) {
		MaximalSquare ms = new MaximalSquare();
		char[][] sqr = new char[][] {
			{'0','1','1','1','0'},
			{'1','1','1','1','1'},
			{'0','1','1','1','1'},
			{'0','1','1','1','1'},
			{'0','1','1','1','1'}
		};
		
		System.out.println(ms.maximalSquare(sqr));
		
		

	}

}
