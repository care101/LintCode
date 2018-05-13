package org.likexin.binarytree;

public class deleteInBST {

  Node deleteNode(Node root, int key) {
    if (root == null) {
      return root;
    }
    if (root.key < key) {
      root.right = deleteNode(root.right, key);
    } else if (root.key > key) {
      root.left = deleteNode(root.left, key);
    } else {
      if (root.left == null && root.right == null) {
        root = null;
      } else if (root.left == null && root.right != null) {
        root = root.right;
      } else if (root.right == null && root.left != null) {
        root = root.left;
      } else if (root.left != null && root.right != null) {
        int min = findMin(root);
        root.key = min;
        root.right = deleteNode(root.right, root.key);
      }
    }
    return root;
  }

  int findMin(Node root) {
    int min = root.key;
    while (root.left != null) {
      min = root.left.key;
      root = root.left;
    }
    return min;
  }

}
