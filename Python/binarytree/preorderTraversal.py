# -*- coding:UTF-8 -*-
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        # solution 1: recursion
        if not root:
            return []        
        ans = []
        ans.append(root.val)
        ans = ans + self.preorderTraversal(root.left) + self.preorderTraversal(root.right)
        return ans        


        # solution 2: loop
        if not root:
            return [] 
        ans = []
        stack = []
        stack.append(root)
        while(stack):
            temp = stack.pop()
            ans.append(temp.val)
            if temp.right:
                stack.append(temp.right)
            if temp.left:
                stack.append(temp.left)
        return ans
        


