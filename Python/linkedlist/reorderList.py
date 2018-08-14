# -*- coding:UTF-8 -*-
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
'''
Solution:
    - 主要就是三个步骤：
        - 找到链表的中点；
        - 反转链表中点后面的链表；
        - 把前后两部分链表交叉连接起来；
'''
class Solution:
    def findMiddle(self, head):
        if not head or not head.next:
            return head
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        return slow
    
    def reverseList(self, head):
        pre, cur = None, head
        while cur:
            temp = cur.next
            cur.next = pre
            pre = cur
            cur = temp
        return pre
    
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        if head and head.next:
            middleNode = self.findMiddle(head)
            l2 = self.reverseList(middleNode.next)
            middleNode.next = None
            cur, cur2 = head, l2
            while cur and cur2:
                temp, temp2 = cur.next, cur2.next
                cur.next = cur2
                cur2.next = temp
                cur = temp
                cur2 = temp2

        