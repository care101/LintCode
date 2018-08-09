# -*- coding:UTF-8 -*-
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
'''
Solution 1:
    - 把链表的val用list装起来，然后去判断这个list是不是回文的；
    - 时间复杂度O(n)，空间复杂度O(n)
Solution 2：
    - 先找到链表的中点（偶数的话，返回前面一个中点），然后把后面这部分链表翻转，然后再去判断这两部分链表是否相同；
    - 时间复杂度O(n)，空间复杂度O(1)
    - 待补充：最后要把链表还原，不能破坏原有的数据结构（之后补充）
'''
class Solution:
    def findMiddle(self, head):
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next    
            fast = fast.next.next        
        return slow
    
    def reverseList(self, head):
        if not head or not head.next:
            return head
        pre, cur = None, head
        while cur:
            nextt = cur.next
            cur.next = pre
            pre = cur
            cur = nextt
        return pre
                
        
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head or not head.next:
            return True
        middleNode = self.findMiddle(head)
        endofList = self.reverseList(middleNode.next)
        nodei, nodej = head, endofList
        while nodej:
            if nodei.val != nodej.val:
                return False
            else:
                nodei = nodei.next
                nodej = nodej.next
        return True
        
        
        
        
#         # Solution 1:       
#         if not head or not head.next:
#             return True
        
#         val_list = []
#         cur = head
#         while cur:
#             val_list.append(cur.val)
#             cur = cur.next
            
#         i, j = 0, len(val_list)-1
#         while i < j:
#             if val_list[i] != val_list[j]:
#                 return False
#             else:
#                 i, j = i+1, j-1
#         return True
        