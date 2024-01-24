package prep.leetcode;

public class ChocolateFeast {
	public static int chocolateFeast(int n, int c, int m) {
        int total=n/c;
        int wrappers=total;
        
        while(wrappers>=m){
            int x = wrappers/m;
            total += x;
            wrappers = x+(wrappers%m);
        }
        return total;
    }

	public static void main(String[] args) {
		ChocolateFeast cf = new ChocolateFeast();
		System.out.println(cf.chocolateFeast(15, 3, 2));

	}

}
