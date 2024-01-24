package prep.leetcode;

public class ReverseLinkedList {
	class Node 
	{
		 int val;
		 Node next;
		 Node() {}
		 Node(int val) { this.val = val; }
		 Node(int val, Node next) { this.val = val; this.next = next; }
	} 
	
	Node head;
	
	public void addAtEnd(Node n)
	{
		if(head == null)
			head = n;
		else
		{
			Node curr = head;
			while(curr.next!=null)
				curr=curr.next;
			curr.next = n;
		}
	}
	
	public Node reverse()
	{
		Node prev = null;
		while(head!=null)
		{
			Node next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
      
    public Node reverseKGroup(Node head, int k) 
    {
    	int count = 0;
        Node ptr = head;

        while (count < k && ptr != null) 
        {
            ptr = ptr.next;
            count++;
        }

        if (count == k) 
        {
        	Node reversedHead = this.reverseLinkedList(head, k);
            head.next = this.reverseKGroup(ptr, k);
            return reversedHead;
        }
            
        return head;
    }
    

    public Node reverseLinkedList(Node head, int k) 
    {   
		Node new_head = null;
		Node ptr = head;
        
        while (k > 0) 
        {
            Node next_node = ptr.next;
            ptr.next = new_head;
            new_head = ptr;
            ptr = next_node;
            k--;
        }
        return new_head;
    }
	
	public void print()
	{
		Node curr=head;
		while(curr!=null)
		{
			if(curr.next==null)
				System.out.print(curr.val);
			else
				System.out.print(curr.val+"->");
			curr=curr.next;
		}
	}

	public static void main(String[] args) 
	{
		ReverseLinkedList rll = new ReverseLinkedList();
		rll.addAtEnd(rll.new Node(1));
		rll.addAtEnd(rll.new Node(2));
		rll.addAtEnd(rll.new Node(3));
		rll.addAtEnd(rll.new Node(4));
		rll.addAtEnd(rll.new Node(5));
		rll.print();
//		rll.head = rll.reverse();
//		System.out.println();
//		rll.print();
		rll.head = rll.reverseKGroup(rll.head, 2);
		System.out.println();
		rll.print();
		

	}

}
