# -*- coding:UTF-8 -*-
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        # solution 1: recursion
        if not root:
            return []
        ans = [root.val]
        return self.postorderTraversal(root.left) + self.postorderTraversal(root.right) + ans
        
        
        # solution 2: loop
        if not root:
            return []
        ans, stack = [], []
        cur, pre = None, None
        stack.append(root)
        while stack:
            cur = stack.pop()
            if (cur.left == None and cur.right == None) or (pre and (pre == cur.left or pre == cur.right)):
                ans.append(cur.val)
                pre = cur
            else:
                stack.append(cur)
                if cur.right:
                    stack.append(cur.right)
                if cur.left:
                    stack.append(cur.left)
        return ans
        
        