# -*- coding:UTF-8 -*-
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
'''
Solution:
    - 这题在list里面加入节点时，只要加入开始节点就可以了，并把末节点的next指向None；
    - 如果一直加入节点，比如加入1,2,3就会出现[1,2,3],[2,3],[3],它是把首节点到末节点的内容都加进去的；
'''

class Solution:
    def splitListToParts(self, root, k):
        """
        :type root: ListNode
        :type k: int
        :rtype: List[ListNode]
        """
        cur = root
        list_len = 0
        while cur:
            list_len += 1
            cur = cur.next
        num, mod = list_len // k, list_len % k
        list_split = []
        cur = root
        for i in range (k):
            temp_list_split = []
            
            if i < mod:    
                temp_list_split.append(cur)
                for j in range(num):                     
                    cur = cur.next
                temp = cur.next
                cur.next = None
                cur = temp
                
            else:
                if num == 0:
                    temp_list_split.append(cur)
                else:       
                    temp_list_split.append(cur)
                    for j in range(num-1):                      
                        cur = cur.next
                    temp = cur.next
                    cur.next = None
                    cur = temp
                                    
            list_split = list_split + temp_list_split
            
        return list_split
        