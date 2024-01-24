package prep.leetcode;

//class ListNode {
//	 int val;
//	 ListNode next;
//	 ListNode() {}
//	 ListNode(int val) { this.val = val; }
//	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

public class RemoveNthNodeFromEnd {
	
	public ListNodeSingle removeNthFromEnd(ListNodeSingle head, int n) 
    {
        ListNodeSingle temp = new ListNodeSingle(0);
        temp.next=head;
        
        ListNodeSingle slow = temp;
        ListNodeSingle fast = temp;
        
        for(int i=1;i<=n+1;i++)
        	fast=fast.next;
        
        while(fast!=null)
        {
        	slow=slow.next;
        	fast=fast.next;
        }
        slow.next = slow.next.next;
        
        return temp.next;
        
    }

	public static void main(String[] args) 
	{
		int[] makeList = new int[] {1,2,3,4,5};
		ListNodeSingle dummy = new ListNodeSingle();
		
		for(int i : makeList)
		{
			
		}

	}

}
