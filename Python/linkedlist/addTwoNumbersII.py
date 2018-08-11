# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def list2Num(self, head):
        num = []
        cur = head
        while cur:
            num.append(cur.val)
            cur = cur.next
        num.reverse()
        res = 0
        for i in range(len(num)):
            res = res + num[i] * (10 ** i)
        return res
    
    def num2List(self, num):
        num_list = []
        if num == 0:
            return ListNode(0)
        while num:
            num_list.append(num%10)
            num = num // 10
        num_list.reverse()
        head = ListNode(num_list[0])
        cur = head
        for i in range(1, len(num_list)):
            cur.next = ListNode(num_list[i])
            cur = cur.next
        return head
    
    
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        num1, num2 = self.list2Num(l1), self.list2Num(l2)
        return self.num2List(num1+num2)
        
        