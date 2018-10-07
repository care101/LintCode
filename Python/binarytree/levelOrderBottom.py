# -*- coding:UTF-8 -*-
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        @ Solution:
        - 这题是用leverOrder那题解法，最后逆序输出列表，但感觉应该有别的做法；（待补充）
        """
        if not root:
            return []
        
        Q, ans = [root], []
        nextQ, temp = [], []
        while Q:
            node = Q.pop(0)
            temp.append(node.val)
            if node.left:
                nextQ.append(node.left)
            if node.right:
                nextQ.append(node.right)
            if not Q:
                Q = nextQ
                ans.append(temp)
                nextQ, temp = [], []
                
        return ans[::-1]
        