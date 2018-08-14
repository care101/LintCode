# -*- coding:UTF-8 -*-
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
'''
Solution:
    - 用两个指针，一个先走n步，然后两个同时前进，直到先走的那个到达链表末尾；
    - 技巧：使用dummyNode指向head，解决链表只有一个元素的情况；
'''
class Solution:
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        dummyNode = ListNode(0)
        dummyNode.next = head
        fast, slow = dummyNode, dummyNode
        for i in range(n):
            fast = fast.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next     
        slow.next = slow.next.next
        
        return dummyNode.next
            
            
        