package prep.leetcode;

public class TicTacToe {
	public String tictactoe(int[][] moves) {
		String[][] board = new String[][] {{"","",""},{"","",""},{"","",""}};
		int n = board.length;
		String currentMove="A";
		for(int[] move : moves)
		{
			switch(currentMove)
			{
				case "A":
					board[move[0]][move[1]]="X";
					if(checkRow(move, board, "X")) return "A";
					if(checkCol(move, board, "X")) return "A";
					if( (move[0]==0 && move[1]==0)||
						(move[0]==1 && move[1]==1)||
						(move[0]==2 && move[1]==2)||
						(move[0]==0 && move[1]==2)||
						(move[0]==2 && move[1]==0))
					{
						if(checkDiags(move, board, "X")) return "A";
					}
					currentMove="B";
					break;
				case "B":
					board[move[0]][move[1]]="O";
					if(checkRow(move, board, "O")) return "B";
					if(checkCol(move, board, "O")) return "B";
					if( (move[0]==0 && move[1]==0)||
						(move[0]==1 && move[1]==1)||
						(move[0]==2 && move[1]==2)||
						(move[0]==0 && move[1]==2)||
						(move[0]==2 && move[1]==0))
					{
						if(checkDiags(move, board, "O")) return "B";
					}
					currentMove="A";
					break;
			}
		}
		
		return moves.length == n * n ? "Draw" : "Pending";
	}
	
	public boolean checkRow(int[] move, String[][] board, String checkSymbol)
	{
		for(int i=0;i<board[0].length;i++)
		{
			if(board[move[0]][i]!=checkSymbol)
				return false;
		}
		return true;
	}
	
	public boolean checkCol(int[] move, String[][] board, String checkSymbol)
	{
		for(int i=0;i<board[0].length;i++)
		{
			if(board[i][move[1]]!=checkSymbol)
				return false;
		}
		return true;
	}
	
	public boolean checkDiags(int[] move, String[][] board, String checkSymbol)
	{
		int rows = board.length;
		int cols = board[0].length;
		boolean diag1=true;
		boolean diag2=true;
		
		for(int i=0,j=0;i<rows && j<cols;i++,j++)
			if(board[i][j]!=checkSymbol)
				diag1 = diag1 && false;
		
		for(int i=0,j=cols-1;i<rows && j>=0;i++,j--)
			if(board[i][j]!=checkSymbol)
				diag2 = diag2 && false;
		
		return diag1 || diag2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToe ttt = new TicTacToe();
		String res = ttt.tictactoe(new int[][] {{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}});
		System.out.println(res);

	}

}
