package prep.interview.compass;

public class DeapthFirstSearch 
{
	public static String getNearestExit(char[][] board, int[] start)
	{
		
		return "";
	}
	
	public static void main(String args[])
	{
		char[][] board1 = new char[][] {
										{'+', '+', '+', '+', '+', '+', '+', '0', '0'},
							            {'+', '+', '0', '0', '0', '0', '0', '+', '+'},
							            {'0', '0', '0', '0', '0', '+', '+', '0', '+'},
							            {'+', '+', '0', '+', '+', '+', '+', '0', '0'},
							            {'+', '+', '0', '0', '0', '0', '0', '0', '+'},
							            {'+', '+', '0', '+', '+', '0', '+', '0', '+'}
							           };


		int[] start1_1 = {2, 0}; // Expected output = {5, 2}
		int[] start1_2 = {0, 7}; // Expected output = {0, 8}   
		int[] start1_3 = {5, 2}; // Expected output = {2, 0} or {5, 5}
		int[] start1_4 = {5, 5}; // Expected output = {5, 7}
	}

}
