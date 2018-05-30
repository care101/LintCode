package org.likexin.binarytree;

public class InsertInBST {

  public static TreeNode insert(TreeNode root, int value) {
    if (root == null) {
      root = new TreeNode(value);
      return root;
    }
    if (root.val > value) {
      root.left = insert(root.left, value);
    }
    if (root.val < value) {
      root.right = insert(root.right, value);
    }
    return root;
  }

}
