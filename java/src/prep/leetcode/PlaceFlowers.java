package prep.leetcode;

public class PlaceFlowers {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if(n==0) return true;
        int ptr=0;
        
        while(ptr<flowerbed.length)
        {
        	if(flowerbed[ptr]==0 && (ptr==0 || flowerbed[ptr-1]==0) 
        			&& (ptr==flowerbed.length-1 || flowerbed[ptr+1]==0))
        	{
        		flowerbed[ptr]=1;
        		n--;
        		if(n==0) return true;
        	}
        	ptr++;
        }

        return false;
    }

	public static void main(String[] args) {
		PlaceFlowers pf = new PlaceFlowers();
		System.out.println(pf.canPlaceFlowers(new int[] {0,0,1,0,0}, 1));

	}

}
