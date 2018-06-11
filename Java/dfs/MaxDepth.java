package org.likexin.dfs;

public class MaxDepth {

  private int depth;

  /**
   * 遍历法
   * @param root: The root of binary tree.
   * @return: An integer
   */
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

  /**
   * 分治法
   * @param root: The root of binary tree.
   * @return: An integer
   */
  public int maxDepth1(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = maxDepth1(root.left);
    int right = maxDepth1(root.right);

    return Math.max(left, right) + 1;
  }

}
