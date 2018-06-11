# 深度优先搜索算法（DFS）

## 基于二叉树的 DFS

### 遍历法 VS 分治法

通过求二叉树的最大深度这道题来感受遍历法和分治法的区别，题目：https://www.lintcode.com/problem/maximum-depth-of-binary-tree/

遍历法：

``` java
public int maxDepth(TreeNode root) {
    depth = 0;
    traversal(root, 1);
    return depth;
  }

private void traversal(TreeNode node, int currDepth) {
  if (node == null) {
    return;
  }

  depth = Math.max(depth, currDepth);

  traversal(node.left, currDepth + 1);
  traversal(node.right, currDepth + 1);
}
```

分治法：

``` java
public int maxDepth(TreeNode root) {
  if (root == null) {
    return 0;
  }

  int left = maxDepth(root.left);
  int right = maxDepth(root.right);

  return Math.max(left, right) + 1;
}
```