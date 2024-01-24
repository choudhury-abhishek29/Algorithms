package prep.leetcode;

//import amberflo.Amberflo;
//import amberflo.Node;

public class MiddleOfLinkedList {
	
	public ListNodeSingle middleNode(ListNodeSingle head) 
    {
        ListNodeSingle a = head;
        ListNodeSingle b = head;
        
        while(b!=null && b.next!=null )
        {
            a=a.next;
            b=b.next.next;
        }
        return a;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNodeSingle n1 = new ListNodeSingle(1);
		ListNodeSingle n2 = new ListNodeSingle(2);
		ListNodeSingle n3 = new ListNodeSingle(3);
		ListNodeSingle n4 = new ListNodeSingle(4);
		ListNodeSingle n5 = new ListNodeSingle(5);
		ListNodeSingle n6 = new ListNodeSingle(6);
		
//		n1.prev=null;
		n1.next=n2;
		
//		n2.prev=n1;
		n2.next=n3;
		
//		n3.prev=n2;
		n3.next=n4;
		
//		n4.prev=n3;
		n4.next=n5;
		
//		n5.prev=n4;
		n5.next=n6;
		
//		n6.prev=n5;
		n6.next=null;
		
		MiddleOfLinkedList a = new MiddleOfLinkedList();
		ListNodeSingle mid = a.middleNode(n1);
		System.out.println(mid.val);

	}

}
