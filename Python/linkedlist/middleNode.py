# -*- coding:UTF-8 -*-
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
'''
Solution:
    - 利用龟兔赛跑思想，两个指针slow，fast，一个每次走一步，一个每次走两步，最终slow的位置就是中点；
'''
class Solution:
    def middleNode(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
            return head
        
        slow, fast = head, head
        while fast.next:
            slow = slow.next
            if fast.next.next:
                fast = fast.next.next
            else:
                break
        return slow
        