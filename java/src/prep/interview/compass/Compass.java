package prep.interview.compass;
import java.io.*;
import java.util.*;

// Snakes may now move in any of four directions - up, down, left, or right - one square at a time, but they will never return to a square that they've already visited.  If a snake enters the board on an edge square, we want to catch it at a different exit square on the board's edge.

// The snake is familiar with the board and will take the route to the nearest reachable exit, in terms of the number of squares it has to move through to get there. Note that there may not be a reachable exit.

// Here is an example board:

//     col-->        0  1  2  3  4  5  6  7  8
//                +---------------------------
//     row      0 |  +  +  +  +  +  +  +  0  0
//      |       1 |  +  +  0  0  0  0  0  +  +
//      |       2 |  0  0  0  0  0  +  +  0  +
//      v       3 |  +  +  0  +  +  +  +  0  0
//              4 |  +  +  0  0  0  0  0  0  +
//              5 |  +  +  0  +  +  0  +  0  +

// Write a function that takes a rectangular board with only +'s and 0's, along with a starting point on the edge of the board, and returns the coordinates of the nearest exit to which it can travel.  If there is a tie, return any of the nearest exits.

// Example: 
// findExit(board1, [2,0]) => [5,2]

// All test cases:
// findExit(board1, start1_1) => [5, 2]
// findExit(board1, start1_2) => [0, 8]
// findExit(board1, start1_3) => [2, 0] or [5, 5]
// findExit(board1, start1_4) => [5, 7]
// findExit(board2, start2_1) => null (or a special value representing no possible exit)
// findExit(board2, start2_2) => null
// findExit(board3, start3_1) => [1, 0]
// findExit(board3, start3_2) => [3, 0]
// findExit(board3, start3_3) => [1, 4]
// findExit(board3, start3_4) => [3, 4]
// findExit(board4, start4_1) => [0, 1]
// findExit(board4, start4_2) => [0, 3]
// findExit(board4, start4_3) => [4, 1]
// findExit(board4, start4_4) => [4, 3]
// findExit(board5, start5_1) => [0, 2]











public class Solution {
  
  public static List<String> getRows(char[][] board)
  {
    int row=board.length;
    int col = board[0].length;
    List<String> result=new ArrayList<String>();
    
    for(int i=0; i<row;i++)
    {
      for(int j=0;j<col;j++)
      {
        if(board[i][j]=='+')
          break;
        else 
          if(j==col-1)          
            result.add("row :"+i);
      }
    }
    return result;    
  }
  
  public static List<String> getColumns(char[][] board)
  {
    int row=board.length;
    int col = board[0].length;
    List<String> result=new ArrayList<String>();
    
    for(int i=0; i<col;i++)
    {
      for(int j=0;j<row;j++)
      {
        if(board[j][i]=='+')
          break;
        else 
          if(j==row-1)          
            result.add("col :"+i);
      }
    }
    return result;    
  }
  
  public static List<String> getValues(char[][] board)
  {
    List<String> result = new ArrayList<String>();
    List<String> rows = getRows(board);
    for(String r : rows)
    {
      result.add(r);
    }
    List<String> columns = getColumns(board);
    for(String r : columns)
    {
      result.add(r);
    }
    
    return result;
    
    
  }
  
  class Node()
  {
    Node parent;
    int[] children;
    
  }
  
  
  public static String getNearestExit(char[][] board)
  {
    HashMap<String, Integer> moves = new HashMap<String, Integer>();
    
  }
  
  public static void main(String[] argv) {
    char[][] board1 = new char[][] {{'+', '+', '+', '+', '+', '+', '+', '0', '0'},
	                                {'+', '+', '0', '0', '0', '0', '0', '+', '+'},
	                                {'0', '0', '0', '0', '0', '+', '+', '0', '+'},
	                                {'+', '+', '0', '+', '+', '+', '+', '0', '0'},
	                                {'+', '+', '0', '0', '0', '0', '0', '0', '+'},
	                                {'+', '+', '0', '+', '+', '0', '+', '0', '+'}};


int[] start1_1 = {2, 0}; // Expected output = {5, 2}
int[] start1_2 = {0, 7}; // Expected output = {0, 8}   
int[] start1_3 = {5, 2}; // Expected output = {2, 0} or {5, 5}
int[] start1_4 = {5, 5}; // Expected output = {5, 7}

char[][] board2 = new char[][] {{'+', '+', '+', '+', '+', '+', '+'},
                                {'0', '0', '0', '0', '+', '0', '+'},
                                {'+', '0', '+', '0', '+', '0', '0'},
                                {'+', '0', '0', '0', '+', '+', '+'},
                                {'+', '+', '+', '+', '+', '+', '+'}};
   
int[] start2_1 = {1, 0}; // Expected output = null (or a special value representing no possible exit)
int[] start2_2 = {2, 6}; // Expected output = null

char[][] board3 = new char[][] {{'+', '0', '+', '0', '+'},
                                {'0', '0', '+', '0', '0'},
                                {'+', '0', '+', '0', '+'},
                                {'0', '0', '+', '0', '0'},
                                {'+', '0', '+', '0', '+'}};

int[] start3_1 = {0, 1}; // Expected output = {1, 0}
int[] start3_2 = {4, 1}; // Expected output = {3, 0}
int[] start3_3 = {0, 3}; // Expected output = {1, 4}
int[] start3_4 = {4, 3}; // Expected output = {3, 4}

char[][] board4 = new char[][] {{'+', '0', '+', '0', '+'},
                                {'0', '0', '0', '0', '0'},
                                {'+', '+', '+', '+', '+'},
                                {'0', '0', '0', '0', '0'},
                                {'+', '0', '+', '0', '+'}};

int[] start4_1 = {1, 0}; // Expected output = {0, 1}
int[] start4_2 = {1, 4}; // Expected output = {0, 3}
int[] start4_3 = {3, 0}; // Expected output = {4, 1}
int[] start4_4 = {3, 4}; // Expected output = {4, 3}

char[][] board5 = new char[][] {{'+', '0', '0', '0', '+'},
                                {'+', '0', '+', '0', '+'},
                                {'+', '0', '0', '0', '+'},
                                {'+', '0', '+', '0', '+'}};

int[] start5_1 = {0, 1}; // Expected output = (0, 2)
int[] start5_2 = {3, 1}; // Expected output = (0, 1)


    


  }
}
