package org.likexin.dfs;

public class IsBalanced {

  int NOT_BALANCED = -1;

  /**
   * 改造求二叉树最大深度 maxDepth 的函数，使得如果使平衡二叉树则返回高度，如果不是则返回 -1。
   *
   * 这样做不好的地方在于 manxDepth 函数返回的值即代表了高度也代表了是否平衡，因此我们可以将这两个属性装进一个 ResultType class，MaxDepth 直接返回 ResultType。
   *
   * @param root: The root of binary tree.
   * @return: True if this Binary tree is Balanced, or false.
   */
  public boolean isBalanced(TreeNode root) {
    return maxDepth(root) != NOT_BALANCED;
  }

  private int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = maxDepth(root.left);
    int right = maxDepth(root.right);

    if (left == NOT_BALANCED || right == NOT_BALANCED) {
      return NOT_BALANCED;
    }

    if (Math.abs(left - right) > 1) {
      return NOT_BALANCED;
    }

    return Math.max(left, right) + 1;
  }
}
