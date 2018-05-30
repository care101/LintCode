package org.likexin.binarytree;

/**
 * http://www.lintcode.com/en/problem/balanced-binary-tree/
 *
 * @author Shingo Lee
 */
public class IsBalanced {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode n1 = new TreeNode(2);
    root.left = n1;
    root.right = new TreeNode(3);

    n1.left = new TreeNode(4);
    n1.right = new TreeNode(5);

    System.out.println(new IsBalanced().isBalanced(root));
  }

  public boolean isBalanced(TreeNode root) {
    return depth(root) != -1;
  }

  private int depth(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int left = depth(node.left);
    int right = depth(node.right);

    if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
      return -1;
    }

    return Math.max(left, right) + 1;
  }

}
