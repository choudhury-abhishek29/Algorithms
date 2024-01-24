package prep.leetcode;

public class SquirellSimulation {
	public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int totalDistance = 0;
        int maxDistance = Integer.MIN_VALUE;
        for (int[] nut : nuts) {
            int curSquirrelDistance = manhattanDistance(squirrel, nut);
            int curNutDistance = manhattanDistance(tree, nut);
            totalDistance += curNutDistance * 2;
            maxDistance = Math.max(maxDistance, curNutDistance - curSquirrelDistance);
        }
        return totalDistance - maxDistance;
    }

    public int manhattanDistance(int[] position1, int[] position2) {
        return Math.abs(position1[0] - position2[0]) + Math.abs(position1[1] - position2[1]);
    }
    
    public static void main(String[] a)
    {
    	SquirellSimulation ss = new SquirellSimulation();
    	int distance = ss.minDistance(5, 7, new int[] {2,2}, new int[] {4,4}, new int[][] {{3,0},{2,5}});
    	System.out.println(distance);
    	/*
    	 * https://leetcode.ca/2017-06-25-573-Squirrel-Simulation/#
    	 * {
    	 * 	{'*','*','*','*','*','*','*'},
    	 * 	{'*','*','*','*','*','*','*'},
    	 * 	{'*','*','T','*','*','N','*'},
    	 * 	{'N','*','*','*','*','*','*'},
    	 * 	{'*','*','*','*','S','*','*'}
    	 * }
    	 * */
    }

}
