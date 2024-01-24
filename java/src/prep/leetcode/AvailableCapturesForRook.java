package prep.leetcode;

public class AvailableCapturesForRook 
{
	public int numRookCaptures(char[][] board) 
	{
		int captures=0;
		int[][] directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
		int [] rook_position = new int[]{0,0};
		
		for(int i=0;i<board.length;i++)
			for(int j=0;j<board[0].length;j++)
			{
				if(board[i][j]=='R')
				{
					rook_position[0]=i;
					rook_position[1]=j;
				}
			}
		
		for(int[] d : directions)
		{
			captures+=canCapture(rook_position, d, board);
		}
        return captures;
    }
	
	private int canCapture(int[] rook_position, int[] d, char[][] board)
	{
		int x=rook_position[0];
		int y=rook_position[1];
		
		while(x>=0 && x<=board.length-1 && y>=0 && y<=board[0].length-1)
		{
			if(board[x][y]=='p')
				return 1;
			else if(board[x][y]=='B')
				break;
			else
			{
				x+=d[0];
				y+=d[1];
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][] {
										{'.','.','.','.','.','.','.','.'},
										{'.','p','p','p','p','p','.','.'},
										{'.','p','p','B','p','p','.','.'},
										{'.','p','B','R','B','p','.','.'},
										{'.','p','p','B','p','p','.','.'},
										{'.','p','p','p','p','p','.','.'},
										{'.','.','.','.','.','.','.','.'},
										{'.','.','.','.','.','.','.','.'}
									};
		
		AvailableCapturesForRook rook = new AvailableCapturesForRook();
		System.out.println(rook.numRookCaptures(board));

	}

}
