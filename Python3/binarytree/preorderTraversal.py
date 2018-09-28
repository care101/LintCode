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
        @ Solution: 递归 & 非递归 
        - 递归: 按照先根节点，左节点，右节点递归即可；
        - 非递归：利用栈，对于当前的root，先压入右节点，再压入左节点；当栈不为空，就一直遍历；
        """

        # Solution2: recursion        
        if not root:
            return []        
        ans = []
        ans.append(root.val)
        ans = ans + self.preorderTraversal(root.left) + self.preorderTraversal(root.right)
        return ans        



        # Solution 1: loop
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


