# 二叉树基础知识 Part 2

## 红黑树(red-black tree)

具有以下性质的被定义为红黑树：

- 每个节点有红或黑两种颜色属性。
- 根节点是黑色属性。
- 相邻两个节点的颜色不能同是红色，即红色节点的父节点和子节点都不能是红色。
- 每一条从根节点到 NULL 节点路径所经历的黑色节点数相同。

![red-black tree](../pic/RedBlackTree.png)

## AVL 树

AVL 树是一颗平衡的 BST。
![AVL TREE](../pic/AVL-Tree.jpg)