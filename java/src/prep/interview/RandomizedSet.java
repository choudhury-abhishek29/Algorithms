package prep.interview;

import java.util.HashSet;
import java.util.Random;

public class RandomizedSet {
	HashSet<Integer> hs;
    public RandomizedSet() {
        hs = new HashSet<Integer>();
    }
    
    public boolean insert(int val) {
        return hs.add(val);
    }
    
    public boolean remove(int val) {
        return hs.remove(val);
    }
    
    public int getRandom() {
        Integer[] arrayNumbers = hs.toArray(new Integer[hs.size()]); 
        Random rndm = new Random();
        int rn = rndm.nextInt(hs.size());
        return arrayNumbers[rn];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
