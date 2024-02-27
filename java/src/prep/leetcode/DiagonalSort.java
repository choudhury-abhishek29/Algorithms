package prep.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class DiagonalSort {
	public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Map<Integer, Queue<Integer>> diagonals = new HashMap<Integer, Queue<Integer>>();

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols;j++){
                diagonals.putIfAbsent(i-j, new PriorityQueue<Integer>());
                diagonals.get(i-j).add(mat[i][j]);
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols;j++){
                mat[i][j] = diagonals.get(i-j).remove();
            }
        }

        return mat;

    }

	public static void main(String[] args) {
		int[][] matrix = new int[][] {	{3,3,1,1},
										{2,2,1,2},
										{1,1,1,2}
									};
		DiagonalSort ds = new DiagonalSort();
		int[][] res = ds.diagonalSort(matrix);
		
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[0].length;j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
			

	}

}
