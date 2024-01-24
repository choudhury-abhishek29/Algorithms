package prep.leetcode;

public class Minesweeper {
	/*
			'M' represents an unrevealed mine,
			'E' represents an unrevealed empty square,
			'B' represents a revealed blank square that has no adjacent mines 
				(i.e., above, below, left, right, and all 4 diagonals),
		*/
	public char[][] updateBoard(char[][] board, int[] click) {
        // once a mine is revealed, we can terminate immediately
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        reveal(board, click[0], click[1]);
        return board;
    }
    
    private void reveal(char[][] board, int i, int j) {
        // edge cases
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'E')
            return;
        
        board[i][j] = '0';
        int[][] neighbors = {{i-1, j-1}, {i-1, j}, {i-1, j+1}, 
                             {i, j-1}, {i, j+1}, 
                             {i+1, j-1}, {i+1, j}, {i+1, j+1}};
        // check all neighbors for number of mines
        for (int[] neighbor : neighbors) {
        	printBoard(board, neighbor);
            if (neighbor[0] < 0 || neighbor[1] < 0 || neighbor[0] >= board.length || neighbor[1] >= board[0].length)
                continue;
            if (board[neighbor[0]][neighbor[1]] == 'M')
                board[i][j] ++;
        }
        
        if (board[i][j] != '0')
            return;
        
        // all neighbors are empty, recursively reveal them
        board[i][j] = 'B';
        for (int[] neighbor : neighbors)
            reveal(board, neighbor[0], neighbor[1]);
    }
    
    
    
    
    
    
    public void printBoard(char[][] board, int[] neighbor)
    {
    	for(int m=0;m<board.length;m++)
		{
			for(int n=0;n<board[0].length;n++)
			{	
				if(m==neighbor[0] && n==neighbor[1])
					System.out.print("["+board[m][n]+"]\t");
				else			
					System.out.print(board[m][n]+"\t");
			}
			System.out.println();
		}
    	System.out.println("----------------------");
    }
	
	public static void main(String[] args)
	{
		Minesweeper ms = new Minesweeper();
		char[][] board = new char[][] {
										{'E','E','E','E','E'},
										{'E','E','M','E','E'},
										{'E','E','E','E','E'},
										{'E','E','E','E','E'}
									};
		char[][] result = ms.updateBoard(board, new int[] {3,0});
		for(int i=0;i<result.length;i++)
		{
			for(int j=0;j<result[0].length;j++)
			{
				System.out.print(" "+result[i][j]+" ");
			}
			System.out.println();
		}
	}

}
