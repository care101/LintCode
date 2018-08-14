# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if not head or not head.next:
            return head
        
        len_list = 0
        cur, end_list = head, head
        while cur:
            end_list = cur
            len_list += 1
            cur = cur.next
                    
        k = k % len_list
        if k == 0:
            return head
        
        cur = head
        for i in range(len_list - k - 1):
            cur = cur.next
        new_head = cur.next
        cur.next = None
        end_list.next = head
        return new_head
        
            
            
        