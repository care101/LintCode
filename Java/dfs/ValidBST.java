package org.likexin.dfs;

public class ValidBST {

  private TreeNode lastNode;
  private boolean isValid;

  /**
   * 中序遍历法
   * @param root: The root of binary tree.
   * @return: True if the binary tree is BST, or false
   */
  public boolean isValidBST(TreeNode root) {
    lastNode = null;
    isValid = true;

    inorderTraverse(root);

    return isValid;
  }

  private void inorderTraverse(TreeNode root) {
    if (root == null) {
      return;
    }

    inorderTraverse(root.left);

    if (lastNode != null && root.val <= lastNode.val) {
      isValid = false;
      return;
    }
    lastNode = root;

    inorderTraverse(root.right);
  }

  /**
   * 分治法：分治法第一步永远是无脑的写出递归 left 和 right 的值，然后再判断运行情况
   * @param root: The root of binary tree.
   * @return: True if the binary tree is BST, or false
   */
  public boolean isValidBST2(TreeNode root) {
    return divideConquer(root).isBST;
  }

  private ResultType divideConquer(TreeNode root) {
    if (root == null) {
      return new ResultType(true);
    }

    ResultType left = divideConquer(root.left);
    ResultType right = divideConquer(root.right);

    if (!left.isBST || !right.isBST) {
      return new ResultType(false);
    }
    if (left.maxNode != null && left.maxNode.val >= root.val) {
      return new ResultType(false);
    }
    if (right.minNode != null && right.minNode.val <= root.val) {
      return new ResultType(false);
    }

    // is bst
    ResultType result = new ResultType(true);
    result.maxNode = right.maxNode != null ? right.maxNode : root;
    result.minNode = left.minNode != null ? left.minNode : root;
    return result;
  }

}

class ResultType {
  public boolean isBST;
  public TreeNode maxNode, minNode;
  public ResultType(boolean isBST) {
    this.isBST = isBST;
    maxNode = null;
    minNode = null;
  }
}