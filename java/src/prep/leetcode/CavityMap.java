package prep.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CavityMap {
	public static List<String> cavityMap(List<String> grid) {
        List<String> cavities = new ArrayList<String>();
        char[][] cav_grid = new char[grid.size()][grid.get(0).length()];
        
        for(int i=0;i<grid.size();i++) {
        	String row = grid.get(i);
        	for(int j=0;j<row.length();j++) {
        		cav_grid[i][j] = row.charAt(j);
        	}
        }
        
        int rows = cav_grid.length-1;
        int cols = cav_grid[0].length-1;
        for(int i=1;i<rows;i++) {
        	for(int j=1;j<cols;j++) {
        		if(cav_grid[i][j]=='X' || cav_grid[i+1][j]=='X' || cav_grid[i-1][j]=='X' 
        				|| cav_grid[i][j+1]=='X' || cav_grid[i][j-1]=='X')
        			continue;
        		
        		char curr_char = cav_grid[i][j];
        		if(curr_char!='X' && (Character.getNumericValue(cav_grid[i+1][j])<Character.getNumericValue(curr_char) 
        				&& Character.getNumericValue(cav_grid[i][j+1])<Character.getNumericValue(curr_char) 
        				&& Character.getNumericValue(cav_grid[i-1][j])<Character.getNumericValue(curr_char) 
        				&& Character.getNumericValue(cav_grid[i][j-1])<Character.getNumericValue(curr_char)))
        				cav_grid[i][j]='X';
        	}
        }
        	
        for(int i=0;i<cav_grid.length;i++) {
        	StringBuffer sb = new StringBuffer();
        	for(int j=0;j<cav_grid[0].length;j++) {
        		sb.append(cav_grid[i][j]);
        	}
        	cavities.add(sb.toString());
        }
        
        return cavities;
    }

	public static void main(String[] args) {
//		System.out.println(Character.getNumericValue('X'));
		
		for(String row : CavityMap.cavityMap(Arrays.asList("179443854","961621369","164139922","968633951",
				"257829163","812438597","176656233","485773814")))
			System.out.println(row);
		
		
//	input:
//		179443854
//		961621369
//		164139922
//		968633951
//		812882578
//		257829163
//		812438597
//		176656233
//		485773814
//	expected:
//		179443854
//		961X21369
//		164139922
//		96X633951
//		812882578
//		25782X163
//		8124385X7
//		176656233
//		485773814
		
//		179443854
//		961X213X9
//		16413X922
//		9X86X3X51
//		25X82X163
//		812438X97
//		17X65X2X3
//		485773814
	}

}
