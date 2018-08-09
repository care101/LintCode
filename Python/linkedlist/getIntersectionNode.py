# -*- coding:UTF-8 -*-
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
'''
Solution: (Python2)
    - 用长度来判断；
    - 或者用python自带的set进行判断，把一个链表的元素加入到set里面，然后看另一个链表的元素在不在这里面；
'''
class Solution(object):
    def nodeLen(self, head):
        length, node = 0, head
        while node:
            length += 1
            node = node.next
        return length    
    
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        # nodeA, nodeB = headA, headB
        # list_ = set()
        # while nodeA:
        #     list_.add(nodeA)
        #     nodeA = nodeA.next
        # while nodeB:
        #     if nodeB in list_:
        #         return nodeB
        #     nodeB = nodeB.next
        # return None    
        
        lenA, lenB = self.nodeLen(headA), self.nodeLen(headB)
        nodeA, nodeB = headA, headB
        while lenA > lenB:
            nodeA = nodeA.next
            lenA -= 1
        while lenA < lenB:
            nodeB = nodeB.next
            lenB -= 1
        while nodeA and nodeA != nodeB:
            nodeA = nodeA.next
            nodeB = nodeB.next
        
        return nodeA
        
            