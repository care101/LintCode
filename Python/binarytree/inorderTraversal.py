# -*- coding:UTF-8 -*-
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        # solution 1: recursion
        if not root:
            return []
        ans = []
        ans.append(root.val)
        ans = self.inorderTraversal(root.left) + ans + self.inorderTraversal(root.right)
        return ans
        

        # solution 2: loop
        if not root:
            return []
        ans, stack = [], []
        p = root
        while p or stack:
            while p:
                stack.append(p)
                p = p.left
            if stack:
                temp = stack.pop()
                ans.append(temp.val)
                p = temp.right
        return ans
    

                
        
        
        