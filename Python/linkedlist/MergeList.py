# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        l3 = ListNode(0)
        i, j, cur = l1, l2, l3
        while i and j:
            if i.val < j.val:
                cur.next = i
                i = i.next
            else:
                cur.next = j
                j = j.next
            cur = cur.next
        while i:
            cur.next = i
            i = i.next
            cur = cur.next
        while j:
            cur.next = j
            j = j.next
            cur = cur.next
            
        return l3.next
                