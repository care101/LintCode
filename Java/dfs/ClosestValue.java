package org.likexin.dfs;

public class ClosestValue {

  /**
   * 1. 先找到小于 target 的最大节点
   * 2. 再找到大于 target 的最小节点
   * 3. 比较两者，选出较小者。
   *
   * @param root: the given BST
   * @param target: the given target
   * @return
   */
  public int closestValue(TreeNode root, double target) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }

    TreeNode lowerNode = lowerBound(root, target);
    TreeNode upperNode = upperBound(root, target);

    if (lowerNode != null && upperNode != null) {
      if (target - lowerNode.val > upperNode.val - target) {
        return upperNode.val;
      } else {
        return lowerNode.val;
      }
    }
    if (lowerNode == null) {
      return upperNode.val;
    }
    if (upperNode == null) {
      return lowerNode.val;
    }
    return root.val;
  }

  /**
   * 找到小于 target 的最大节点
   *
   * TODO: 理解递归时 return lowerBound(root.left, target); 和 TreeNode lowerNode = lowerBound(root.right, target); 的区别
   *
   * @param root: the given BST
   * @param target: the given target
   * @return: the value in the BST that is smallest value larger than the target
   */
  private TreeNode lowerBound(TreeNode root, double target) {
    if (root == null) {
      return null;
    }
    if (root.val > target) {
      return lowerBound(root.left, target);
    }
    TreeNode lowerNode = lowerBound(root.right, target);
    if (lowerNode != null) {
      return lowerNode;
    }
    return root;
  }

  /**
   * 找到大于 target 的最小节点
   *
   * @param root: the given BST
   * @param target: the given target
   * @return: the value in the BST that is largest value smaller than the target
   */
  private TreeNode upperBound(TreeNode root, double target) {
    if (root == null) {
      return null;
    }
    if (root.val < target) {
      return upperBound(root.right, target);
    }
    TreeNode upperNode = upperBound(root.left, target);
    if (upperNode != null) {
      return upperNode;
    }
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(8);

    root.left = new TreeNode(3);
    root.right = new TreeNode(10);

    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(6);
    root.right.right = new TreeNode(14);

    root.left.right.left = new TreeNode(4);
    root.left.right.right = new TreeNode(7);
    root.right.right.left = new TreeNode(13);

    new ClosestValue().closestValue(root, 4.666);
  }
}
