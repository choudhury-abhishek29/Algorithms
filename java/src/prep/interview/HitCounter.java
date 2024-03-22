package prep.interview;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
	Queue<Integer> q;
    public HitCounter() {
        q = new LinkedList<Integer>();
    }
    
    public void hit(int timestamp) {
        q.offer(timestamp);
    }
    
    public int getHits(int timestamp) {
        while(!q.isEmpty() && timestamp-q.peek()>=300)
            q.poll();

        return q.size();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
