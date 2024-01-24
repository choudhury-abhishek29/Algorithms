package prep.leetcode;



public class MergeKSortedLists {
	
	class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	public ListNode mergeKLists(ListNode[] lists) {
		int interval=1;
		while(interval<lists.length)
		{
			for(int i=0; i+interval<lists.length; i=i+interval*2)
			{
				lists[i] = mergeTwoLists(lists[i], lists[i+interval]);
			}
			interval*=2;
		}
        return lists[0];
    }
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2)
	{
		ListNode temp = new ListNode();
		ListNode curr = temp;
		
		while(list1!=null && list2!=null)
		{
			if(list1.val < list2.val)
			{
				curr.next = list1;
				list1 = list1.next;
			}
			else
			{
				curr.next = list2;
				list2 = list2.next;
			}
			curr = curr.next;
		}
		
		if(list1!=null)
		{
			curr.next = list1;
			list1 = list1.next;
		}
		
		if(list2!=null)
		{
			curr.next = list2;
			list2 = list2.next;
		}
		return temp.next;
	}
	
	public static void main(String[] args)
	{
		int interval=1;
        while(interval<5)
        {
        	for(int i=0;i+interval<5;i=i+interval*2)
        	{
        		int next = i+interval;
        		System.out.println("i : "+i);
        		System.out.println("i+interval : "+next);
        		
        	}
        	interval=interval*2;
        }
	}

}
