"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

class Solution:
    """
    @param root: The root of binary tree.
    @return: An integer
    """
    def maxDepth(self, root):
        # write your code here
        depth = 1
        if not root:
          return 0
        depth += max(self.maxDepth(root.left), self.maxDepth(root.right))
        return depth
        

