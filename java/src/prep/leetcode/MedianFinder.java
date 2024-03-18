package prep.leetcode;

import java.util.PriorityQueue;

public class MedianFinder {
	
	private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
	int size=0;
	
	
	//time complexity : 0(1)
	public double findMedian() {
	    if (size%2==0)
	        return (minHeap.peek() + maxHeap.peek()) / 2.0;
	    else
	        return maxHeap.peek();
	}
	
	
	//time complexity : o(log(n))
	public void addNum(int num) {
		size++;
		
		if(maxHeap.isEmpty() || num<=maxHeap.peek())
			maxHeap.add(num);
		else
			minHeap.add(num);
		
		
		if(minHeap.size()+1<maxHeap.size())
			minHeap.add(maxHeap.poll());
		else if(maxHeap.size()<minHeap.size())
			maxHeap.add(minHeap.poll());
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
