package prep.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
	
	private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
	private PriorityQueue<Integer> large = new PriorityQueue<>();
	boolean even=true;
	
	public double findMedian() {
	    if (even)
	        return (small.peek() + large.peek()) / 2.0;
	    else
	        return small.peek();
	}

	public void addNum(int num) {
	    if (even) {
	        large.offer(num);
	        small.offer(large.poll());
	    } else {
	        small.offer(num);
	        large.offer(small.poll());
	    }
	    even = !even;
	}

	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		mf.addNum(2);
		mf.addNum(3);
		mf.addNum(4);
		mf.addNum(5);
		System.out.println(mf.findMedian());
		
		

	}

}
