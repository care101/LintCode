# -*- coding:UTF-8 -*-
"""
Definition of ListNode

class ListNode(object):

    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""

class Solution:
    """
    @ param head: n
    @ return: The new head of reversed linked list.
    @ solution:
    - 利用三个变量：pre, cur, next分别记住前一个、当前和后一个Node即可；
    """
    def reverse(self, head):
        # write your code here
        if not head or not head.next:
            return head
        pre, cur = None, head
        while cur:
            nextt = cur.next
            cur.next = pre 
            pre = cur 
            cur = nextt
        
        return pre
