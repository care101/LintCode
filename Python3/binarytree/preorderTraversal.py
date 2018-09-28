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
        if not root:
            return []
        
        ans = []
        ans.append(root.val)
        temp_left, temp_right = [], []
        if root.left:
            temp_left = self.preorderTraversal(root.left)
        if root.right:
            temp_right = self.preorderTraversal(root.right)
        ans = ans + temp_left + temp_right  
        return ans        

