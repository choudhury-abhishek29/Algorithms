package test;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<Integer> minq = new PriorityQueue<Integer>((a,b)->a-b);
		PriorityQueue<Integer> maxq = new PriorityQueue<Integer>((a,b)->b-a);
		
		minq.add(10);
		minq.add(40);
		minq.add(60);
		minq.add(20);
		minq.add(100);
		
		maxq.add(10);
		maxq.add(40);
		maxq.add(60);
		maxq.add(20);
		maxq.add(100);
		
		System.out.println("minq : "+minq);
		System.out.println("maxq : "+maxq);

	}

}
