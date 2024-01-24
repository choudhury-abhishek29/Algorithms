package prep.interview;


// Main class should be named 'Solution' and should not be public.
public class Ebay {
    public int findNumCategories(char[][] grid){
        
        int num=0;
        for(int i=0; i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                num+=countCategories(i, j, grid);
            }
        }
        
        return num;
    }
    
    public int countCategories(int row, int col, char[][] grid){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]=='V' || grid[row][col]=='0')
            return 0;
        else{
            grid[row][col]='V';
            countCategories(row+1, col, grid);
            countCategories(row-1, col, grid);
            countCategories(row, col+1, grid);
            countCategories(row, col-1, grid);
            return 1;
        }
    }
    
    public static void main(String[] args) {
        
        char[][] grid1 = new char[][]{};
                                    
        char[][] grid2 = new char[][]{{'C','C','0','C','0'},
                                      {'C','C','0','C', '0'},
                                      {'C','C','0','0','0'},
                                      {'0','0','0','0','C'}};
                                    
        char[][] grid3 = new char[][]{{'C','C','0','C','0'},
                                    {'0','0','C','0', '0'},
                                    {'0','C','0','C','0'},
                                    {'0','0','0','0','C'}};
  
  
  
        Ebay s = new Ebay();
        System.out.println("grid1 : "+s.findNumCategories(grid1));
        System.out.println("grid2 : "+s.findNumCategories(grid2));
        System.out.println("grid3 : "+s.findNumCategories(grid3));
    }
}
/*
Input
CategoryGrid = [
  ["C","C","0","C","0"],
  ["C","C","C","C","0"],
  ["C","C","0","C","0"],
  ["0","0","0","C","C"]
]
Output: 1
*/
