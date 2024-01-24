package revise;

class LinkedListNode
{
	LinkedListNode prev;
	int data;
	LinkedListNode next;
	
	public LinkedListNode(int data)
	{
		prev=null;
		this.data=data;
		next=null;
	}
	
}


public class ReviseLinkedList 
{
	LinkedListNode head;
		
	public void addNodeAtEnd(LinkedListNode node)
	{
		if(head==null)
		{
			head=node;
		}
		else
		{
			LinkedListNode curr = head;
			while(curr.next!=null)
				curr=curr.next;
			curr.next=node;
			node.prev=curr;
		}
	}
	
	public void addNodeAtStart(LinkedListNode node)
	{
		head.prev=node;
		node.next=head;
		head=node;
	}
	
	public void addNodeInBetween(int prevNode, LinkedListNode node)
	{
		LinkedListNode curr=head;
		while(curr.data!=prevNode)
			curr=curr.next;
		
		LinkedListNode next=curr.next;
		node.next = next;
		node.prev = curr;
		curr.next = node;
		next.prev = node;
		
	}
	
	public void searchNode(int data)
	{
		LinkedListNode curr = head;
		while(curr!=null)
		{
			if(curr.data==data)
			{
				System.out.println("Found : "+curr.data);
				return;
			}
			curr=curr.next;
		}
		System.out.println("Node not found");
	}
	
	public void removeNode(int data)
	{
		LinkedListNode curr = head;
		
		if(curr.data==data)
		{
			head=curr.next;
			head.prev=null;			
		}
		else
		{
			while(curr.data!=data)
				curr=curr.next;
			
			if(curr.next==null)
			{
				LinkedListNode prev = curr.prev;
				prev.next=null;
				
			}
			else
			{
				LinkedListNode prev = curr.prev;
				LinkedListNode next = curr.next;
				prev.next = next;
				next.prev = prev;
			}
		}
	}
	
	public void print()
	{
		LinkedListNode curr = head;
		while(curr!=null)
		{
			System.out.print(curr.data+"->");
			curr=curr.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		ReviseLinkedList rll = new ReviseLinkedList();
		rll.addNodeAtEnd(new LinkedListNode(1));
		rll.addNodeAtEnd(new LinkedListNode(2));
		rll.addNodeAtEnd(new LinkedListNode(3));
		rll.addNodeAtEnd(new LinkedListNode(4));
		rll.addNodeAtEnd(new LinkedListNode(5));
		rll.addNodeAtEnd(new LinkedListNode(6));
		rll.print();
		
		rll.removeNode(4);
		rll.print();
		
		rll.addNodeInBetween(3, new LinkedListNode(4));
		rll.print();
		
	}

}
