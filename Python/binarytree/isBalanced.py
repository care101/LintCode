# -*- coding:UTF-8 -*-
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
'''
Solution:
    - Solution1：O(NlogN)，根据平衡二叉树的定义，利用计算二叉树深度的函数，进行判断；
    - Solution2：O(N)，利用DFS，在计算二叉树深度时，同时判断当前子树是否为平衡二叉树，不平衡则返回-1，否则返回较大的深度，作为当前结点的深度；
'''

class Solution:
    # ------------- Solution1 ------------------
    def depth(self, root):
        if not root:
            return 0
        return max(self.depth(root.left), self.depth(root.right)) + 1
    
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        return abs(self.depth(root.left)-self.depth(root.right))<=1 and self.isBalanced(root.left) and self.isBalanced(root.right)
           
    

    # ------------- Solution2 ------------------
    def DFSHeight(self, root):
        if not root:
            return 0
        LHeight = self.DFSHeight(root.left)
        RHeight = self.DFSHeight(root.right)
        if LHeight == -1 or RHeight == -1 or abs(LHeight-RHeight) >1:
            return -1
        return max(LHeight,RHeight)+1
    
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.DFSHeight(root) != -1


     