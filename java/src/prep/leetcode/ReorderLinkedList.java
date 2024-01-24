package prep.leetcode;

import prep.leetcode.ListNodeSingle;

public class ReorderLinkedList {
	public void reorderList(ListNodeSingle head) {
		if(head==null || head.next==null)
            return;
		ListNodeSingle l1 = head;
		ListNodeSingle slow = head;
		ListNodeSingle fast = head;
		ListNodeSingle prev = null;
        
        boolean even = true;

        while(fast!=null && fast.next!=null){
        	prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next=null;
        
        ListNodeSingle l2 = reverseList(slow);

        ListNodeSingle temp = new ListNodeSingle();
        ListNodeSingle curr = temp;
        while(l1!=null && l2!=null){
            if(even){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            
            curr = curr.next;
            even = !even;
        }
        
        if(l1!=null) {
        	curr.next = l1;
        	l1 = l1.next;
        }
        
        if(l2!=null) {
        	curr.next = l2;
        	l2 = l2.next;
        }

    }

    public ListNodeSingle reverseList(ListNodeSingle node) {
    	ListNodeSingle prev = null;
        while(node!=null){
        	ListNodeSingle next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
    
    public void printList(ListNodeSingle head) {
    	ListNodeSingle curr = head;
		while(curr!=null) {
			System.out.print(curr.val+"->");
			curr=curr.next;
		}
		System.out.println();
    }
    

	public static void main(String[] args) {
		ListNodeSingle n1 = new ListNodeSingle(1);
		ListNodeSingle n2 = new ListNodeSingle(2);
		ListNodeSingle n3 = new ListNodeSingle(3);
		ListNodeSingle n4 = new ListNodeSingle(4);
		ListNodeSingle n5 = new ListNodeSingle(5);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		
		ReorderLinkedList rll = new ReorderLinkedList();
		rll.reorderList(n1);
		
		rll.printList(n1);

	}

}
