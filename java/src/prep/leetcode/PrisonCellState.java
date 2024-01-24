package prep.leetcode;

import java.util.HashMap;

public class PrisonCellState {
	public int[] prisonAfterNDays(int[] cells, int N) {

        HashMap<Integer, Integer> seen = new HashMap<>();
        boolean isFastForwarded = false;

        // step 1). convert the cells to bitmap
        int stateBitmap = 0x0;
        for (int cell : cells) {
            stateBitmap <<= 1;
            stateBitmap = (stateBitmap | cell);
        }

        // step 2). run the simulation with hashmap
        while (N > 0) {
            if (!isFastForwarded) {
                if (seen.containsKey(stateBitmap)) {
                    // the length of the cycle is seen[state_key] - N
                    N %= seen.get(stateBitmap) - N;
                    isFastForwarded = true;
                } else
                    seen.put(stateBitmap, N);
            }
            // check if there is still some steps remained,
            // with or without the fast forwarding.
            if (N > 0) {
                N -= 1;
                stateBitmap = this.nextDay(stateBitmap);
            }
        }

        // step 3). convert the bitmap back to the state cells
        int ret[] = new int[cells.length];
        for (int i = cells.length - 1; i >= 0; i--) {
            ret[i] = (stateBitmap & 0x1);
            stateBitmap = stateBitmap >> 1;
        }
        return ret;
    }

    protected int nextDay(int stateBitmap) {
        stateBitmap = ~(stateBitmap << 1) ^ (stateBitmap >> 1);
        // set the head and tail to zero
        stateBitmap = stateBitmap & 0x7e;
        return stateBitmap;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrisonCellState pcs = new PrisonCellState();
		int[] res = pcs.prisonAfterNDays(new int[] {0, 1, 0, 1, 1, 0, 0, 1}, 1);
		//0, 0, 0, 1, 1, 1, 0, 0 			  
		//0, 1, 1, 0, 0, 0, 0, 0 : expected
		for(int n : res)
			System.out.print(n+" ");

	}

}
