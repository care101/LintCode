# -*- coding:UTF-8 -*-
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
'''
Solution:
    - 使用一个虚拟的head，指向真正的head；
'''
class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        if not head:
            return head
        
        fakeHead = ListNode(0)
        fakeHead.next = head
        pre, cur = fakeHead, fakeHead.next
        while cur:
            if cur.val == val:
                pre.next = cur.next
                cur = cur.next
            else:
                pre = cur
                cur = cur.next
                
        return fakeHead.next