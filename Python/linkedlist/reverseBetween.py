# -*- coding:UTF-8 -*-
'''
Solution：
    - 主要就是保存好几个位置的Node，然后reverseList，然后再把他们连接起来；
    - 这边要记录m, n, m-1, n+1位置的Node，这边n位置的结点可以省掉，在做reverse时，就是最后的那个pre结点；
    - 要注意的是：在reverse环节中(即num >= m and num <= n)，cur已经变为cur.next，所以最后的cur=cur.next要在num < m or num > n的情况进行；
'''
class Solution:
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """
        if not head or not head.next:
            return head
        
        m_before_node = None
        mNode = None
        pre, cur = None, head
        num = 0
        while cur:
            num += 1
            if num == m - 1:
                m_before_node = cur        
            if num == m:
                mNode = cur
            if num == n:
                nNode = cur               
            if num >= m and num <= n:
                temp = cur.next
                cur.next = pre 
                pre = cur
                cur = temp 
            if num > n:
                mNode.next = cur
                break
            if num < m or num > n:
                cur = cur.next
        if m == 1:
            return pre
        else:
            m_before_node.next = pre
        return head     
