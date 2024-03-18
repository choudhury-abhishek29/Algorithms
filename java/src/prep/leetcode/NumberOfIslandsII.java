package prep.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> counts = new ArrayList<Integer>();

        int[][] grid = new int[m][n];

        for(int[] pos : positions){
            grid[pos[0]][pos[1]]=1;
            counts.add(countIslands(grid));
        }

        return counts;
    }

    public int countIslands(int[][] grid){
        int count = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                count+=getCount(i,j,grid);
            }
        }
        return count;
    }

    public int getCount(int row, int col, int[][] grid){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]=='V')
            return 0;
        else{
            grid[row][col]='V';
            getCount(row+1, col, grid);
            getCount(row, col+1, grid);
            getCount(row-1, col, grid);
            getCount(row, col-1, grid);
            return 1;
        }
    }

	public static void main(String[] args) {
		NumberOfIslandsII nit = new NumberOfIslandsII();
		System.out.println(nit.numIslands2(3, 3, new int[][] {{0,0},{0,1},{1,2},{2,1}}));

	}

}
