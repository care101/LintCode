# -*- coding:UTF-8 -*-
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        @ Solution:
        - 前序遍历：根左右； 中序遍历：左根右
        - 前序遍历的第一个值就是根节点，在中序遍历中找到根节点，左侧是左子树，右侧是右子树；
        - 利用递归，再对左子树和右子树分别建树；
        """
        if not preorder:
            return None
        head = TreeNode(preorder[0])
        root_index = 0
        while inorder[root_index] != preorder[0]:
            root_index += 1
        
        left = self.buildTree(preorder[1:1+root_index], inorder[0:root_index])
        right = self.buildTree(preorder[1+root_index:], inorder[root_index+1:])
        
        head.left = left
        head.right = right
        
        return head
    