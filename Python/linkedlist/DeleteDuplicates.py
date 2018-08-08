# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
            return head
        pre, cur = head, head.next
        while cur:
            nextt = cur.next
            if pre.val == cur.val:
                pre.next = nextt
                cur = nextt
                
            else:
                pre = cur
                cur = nextt
                
        return head