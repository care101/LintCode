# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def calculate(self, head):
        cur, res, i = head, 0, 0
        while cur:
            res = res + cur.val * 10 ** i
            i += 1
            cur = cur.next
        return res              
    
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        num1, num2 = self.calculate(l1), self.calculate(l2)
        num = num1 + num2
        print(num1, num2, num)
        
        l3 = ListNode(num%10)
        cur = l3
        temp = num // 10
        while temp:
            # print(temp)
            cur.next = ListNode(temp%10)
            cur = cur.next
            temp = temp // 10
        return l3
        