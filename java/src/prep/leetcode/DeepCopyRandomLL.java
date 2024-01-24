package prep.leetcode;

import java.util.HashMap;

class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class DeepCopyRandomLL {
	public RandomNode copyRandomList(RandomNode head) {
		RandomNode curr = head;
        HashMap<RandomNode, RandomNode> nl = new HashMap<RandomNode, RandomNode>();

        while(curr!=null){
        	RandomNode n = new RandomNode(curr.val);
            nl.put(curr, n);
            curr=curr.next;
        }
        curr=head;
        
        while(curr!=null){
        	RandomNode n = nl.get(curr);
            n.next = nl.get(curr.next);
            n.random = nl.get(curr.random);
            curr = curr.next;
        }
        curr=head;

        
        return nl.get(curr);
    }
	
	private void printList(RandomNode head) {
		RandomNode curr = head;
		while(curr!=null) {
			String next_val = (curr.next==null)?"null":String.valueOf(curr.next.val);
			String random_val = (curr.random==null)?"null":String.valueOf(curr.random.val);
			System.out.print("[val:"+curr.val+"|next:"+next_val+"|random:"+random_val+"] -> ");
			curr=curr.next;
		}
		
		System.out.println("");
	}

	public static void main(String[] args) {
		RandomNode n0 = new RandomNode(7);
		RandomNode n1 = new RandomNode(13);
		RandomNode n2 = new RandomNode(11);
		RandomNode n3 = new RandomNode(10);
		RandomNode n4 = new RandomNode(1);
		
		n0.next = n1;
		
		n1.next = n2;
		n1.random = n0;
		
		n2.next = n3;
		n2.random = n4;
		
		n3.next = n4;
		n3.random = n2;
		
		n4.random = n0;
		
		DeepCopyRandomLL dcrl = new DeepCopyRandomLL();
		dcrl.printList(n0);
		RandomNode new_head = dcrl.copyRandomList(n0);
		dcrl.printList(new_head);
				
		

	}

}
