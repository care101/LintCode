package org.likexin.binarytree;

/**
 * http://www.lintcode.com/en/problem/subtree-with-maximum-average/
 *
 * @author Shingo Lee
 */
public class FindSubtreeII {

  private TreeNode subtree = null;
  private ResultType subtreeResult = null;

  public TreeNode findSubtreeII(TreeNode root) {
    helper(root);
    return subtree;
  }

  private ResultType helper(TreeNode node) {
    if (node == null) {
      return new ResultType(0, 0);
    }

    ResultType left = helper(node.left);
    ResultType right = helper(node.right);
    ResultType result = new ResultType(left.sum + right.sum + node.val, left.size + right.size + 1);

    if (subtree == null || subtreeResult.sum * result.size < result.sum * subtreeResult.size) {
      subtree = node;
      subtreeResult = result;
    }

    return result;
  }

  private class ResultType {
    public int sum;
    public int size;

    public ResultType(int sum, int size) {
      this.sum = sum;
      this.size = size;
    }
  }

}