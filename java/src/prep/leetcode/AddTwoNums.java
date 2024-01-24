package prep.leetcode;

//
// Definition for singly-linked list.
 
 

public class AddTwoNums {
	class ListNode {
	     int val;
	     ListNodeSingle next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNodeSingle next) { this.val = val; this.next = next; }
	 }
	public static ListNodeSingle addTwoNumbers(ListNodeSingle l1, ListNodeSingle l2) 
    {
        ListNodeSingle dummy_head = new ListNodeSingle(0);
        ListNodeSingle curr = dummy_head;
        int carry=0;
        while(l1!=null || l2!=null)
        {
            int l1_val = (l1!=null)?l1.val:0;
            int l2_val = (l2!=null)?l2.val:0;
            int sum = l1_val+l2_val+carry;
            curr.next = new ListNodeSingle(sum%10);
            carry = sum/10;
            
            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
            curr = curr.next;
        }
        if(carry>0)
        {
            curr.next = new ListNodeSingle(carry);
            curr = curr.next;
        }
        
        return dummy_head.next;
    }
	
	public static void main(String args[])
	{
//		ListNode l1 = [2,4,3]; 
//		ListNode l2 = [5,6,4];
		
	}

}
