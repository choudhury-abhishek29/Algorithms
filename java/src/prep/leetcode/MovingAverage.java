package prep.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MovingAverage {
//	List<Integer> ma;
//    int size;
//    public MovingAverage(int size) 
//    {
//        ma = new ArrayList<Integer>(size);
//        this.size = size;
//    }
//    
//    public double next(int val) 
//    {
//        double sum=0;
//        double avg=0;
//        
//        if(ma.size()<this.size)
//        {
//            ma.add(val);
//        }
//        else
//        {
//            ma.remove(0);
//            ma.add(val);
//        }
//        
//        for(int v : ma)
//            sum+=v;
//        
//        avg = sum/ma.size();
//        
//        return avg;
//	}
	
	int size;
    double sum;
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new LinkedList<Integer>();
        this.size  = size;
        this.sum   = 0;
    }

    public double next(int val) {
        if (this.queue.size() == this.size) this.sum -= this.queue.poll();

        this.sum += val;
        this.queue.add(val);
        return this.sum / this.queue.size();
    }
    
    
    public static void main(String[] args)
    {
    	MovingAverage movingAverage = new MovingAverage(3);
    	System.out.println(movingAverage.next(1)); // return 1.0 = 1 / 1
    	System.out.println(movingAverage.next(10)); // return 5.5 = (1 + 10) / 2
    	System.out.println(movingAverage.next(3)); // return 4.66667 = (1 + 10 + 3) / 3
    	System.out.println(movingAverage.next(5)); // return 6.0 = (10 + 3 + 5) / 3
    }

}
