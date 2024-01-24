package prep.leetcode;

import java.util.HashSet;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) 
	{
        HashSet<String> seen = new HashSet<String>();

        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                char curr = board[i][j];
                if(curr!='.')
                {
                	if(!seen.add(curr+" found in row "+i) || 
                	   !seen.add(curr+" found in col "+j) || 
                	   !seen.add(curr+" found in box "+i/3+"-"+j/3))
                		return false;
                }
            }
        }
        return true;
    }

	public static void main(String[] args) {
		char[][] board = new char[][] {
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
		};
		
		ValidSudoku vs = new ValidSudoku();
		System.out.println(vs.isValidSudoku(board));

	}

}
