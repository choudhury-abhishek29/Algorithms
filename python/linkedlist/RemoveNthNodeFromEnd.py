from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        first = head
        second = head

        for i in range(n):
            first = first.next

        if not first:
            return head.next

        while first.next:
            first = first.next
            second = second.next

        second.next = second.next.next

        return head

    def printList(self, head: Optional[ListNode]):
        curr = head;
        l=""
        while curr:
            l+=str(curr.val)+"->"
            curr = curr.next
        print(l)

head = ListNode()
node1 = ListNode(1)
node2 = ListNode(2)
node3 = ListNode(3)
node4 = ListNode(4)
node5 = ListNode(5)

head.next = node1
node1.next = node2
node2.next = node3
node3.next = node4
node4.next = node5

s = Solution()
s.printList(head)
s.removeNthFromEnd(head, 2)
s.printList(head)



