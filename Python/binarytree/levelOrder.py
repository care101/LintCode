# -*- coding:UTF-8 -*-
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        @ Solution:
        - 二叉树的层序遍历需要用到队列，先进先出；Python用列表的pop(0)来模仿队列；
        - 题目要求按层输出，所以需要知道一层有多少个节点，这边使用两个队列 Q, nextQ 分别存放当前层节点以及下一层节点；
          在 Q 中节点访问完时，把 nextQ 赋给 Q ；
        - 或者只用一个队列，额外使用傀儡节点表示当前层结束；或者标记当前层节点的个数；（这里没有实现，后续再补）
        """
        if not root:
            return []
        Q = [root]
        ans = []
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
                
        return ans
            
        