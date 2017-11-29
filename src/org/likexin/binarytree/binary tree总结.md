# Binary Tree 总结

## Traverse vs Divide Conquer

- traverse：一般都是从root出来，带着结果往下遍历，一般是自顶向下的做法。
- divide & conquer：一般是求出子树（子问题）的解后，合并出当前子树（当前规模的问题）的解。这是一个自底向上合并的过程。
- 都是属于递归算法
- Result in parameter vs Result in return value 
- 自顶而下 vs 自底而上

## 平衡二叉树（AVL树）

定义：是一颗空树或者左子树和右子树的高度差不大于 1。

## 二叉树的遍历
 
- 前序遍历(Preorder)：根左右
- 中序遍历(Inorder)：左根右
- 后序遍历(Postorder)：左右根

其中 Preorder 和 Inorder 要求会迭代的写法，而不仅仅是递归的写法。

## 关于二叉树的面试资料
http://blog.sina.com.cn/s/blog_eb52001d0102v1si.html

## 理解递归
http://www.nowamagic.net/librarys/veda/detail/2314