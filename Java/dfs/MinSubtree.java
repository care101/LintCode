package org.likexin.dfs;

public class MinSubtree {

  private TreeNode subtree = null;
  private int sum = Integer.MAX_VALUE;

  /**
   * Traverse + Divide Conquer
   *
   * @param root: the root of binary tree
   * @return: the root of the minimum subtree
   */
  public TreeNode findSubtree(TreeNode root) {
    if (root == null) {
      return null;
    }
    helper(root);
    return subtree;
  }

  private int helper(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int currSum = helper(root.left) + helper(root.right) + root.val;
    if (sum > currSum) {
      sum = currSum;
      subtree = root;
    }
    return currSum;
  }

  /**
   * Pure Divide Conquer
   *
   * @param root: the root of binary tree
   * @return: the root of the minimum subtree
   */
  public TreeNode findSubtree2(TreeNode root) {
    ResultType result = divideConquer(root);
    return result.minSubtree;
  }

  private ResultType divideConquer(TreeNode root) {
    if (root == null) {
      return new ResultType(null, 0, Integer.MAX_VALUE);
    }

    ResultType left = divideConquer(root.left);
    ResultType right = divideConquer(root.right);

    ResultType result = new ResultType(
            root,
            left.sum + right.sum + root.val,
            left.sum + right.sum + root.val
            );

    if (result.minSum > left.minSum) {
      result.sum = left.sum;
      result.minSubtree = left.minSubtree;
    }
    if (result.minSum > right.minSum) {
      result.minSum = right.minSum;
      result.minSubtree = right.minSubtree;
    }
    return result;
  }

  class ResultType {
    TreeNode minSubtree;
    int sum, minSum;
    ResultType(TreeNode minSubtree, int sum, int minSum) {
      this.minSubtree = minSubtree;
      this.sum = sum;
      this.minSum = minSum;
    }
  }

}