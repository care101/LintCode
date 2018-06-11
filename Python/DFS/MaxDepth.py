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
    def findDepth(self, root):
      depth_l = 1
      depth_r = 1
      if root.left:
        depth_l += self.findDepth(root.left)
      if root.right:
        depth_r += self.findDepth(root.right)
      return max(depth_l, depth_r)
      
    def maxDepth(self, root):
        # write your code here
        if not root:
          return 0
        return self.findDepth(root)
        

