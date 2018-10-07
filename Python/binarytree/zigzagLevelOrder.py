# -*- coding:UTF-8 -*-
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        @ Solution:
        - 思路与 Binary Tree Level Order Traversal 类似，这边使用的是两个栈；
        - 利用一个标志位flag，当flag=1时，栈内先放左子结点，再右子结点，否则先右再左；
        """
        if not root:
            return []
        
        Q, ans = [root], []
        flag = 1
        nextQ, temp = [], []
        while Q:
            node = Q.pop()
            temp.append(node.val)
            if flag:
                if node.left:
                    nextQ.append(node.left)
                if node.right:
                    nextQ.append(node.right)
            else:
                if node.right:
                    nextQ.append(node.right)
                if node.left:
                    nextQ.append(node.left)
                    
            if not Q:
                Q = nextQ
                ans.append(temp)
                flag = flag ^ 1
                nextQ, temp = [], []
                
        return ans
                
        