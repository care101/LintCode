package org.likexin.binarytree;

public class SearchInBST {

    public TreeNode searchReturnObject(TreeNode root, int key) {
        if (root == null || root.val == key) {
            return root;
        }
        if (root.val < key) {
            return searchReturnObject(root.right, key);
        }
        if (root.val > key) {
            return searchReturnObject(root.left, key);
        }
        return null;
    }

    /**
     *  if (root == null || root.val == key) {
            return root.val;
        }
        这句出现空指针的原因是当root==null时return root.val
     */
    public static int searchReturnInteger(TreeNode root, int key) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.val == key) {
            return root.val;
        }
        if (root.val < key) {
            return searchReturnInteger(root.right, key);
        }
        if (root.val > key) {
            return searchReturnInteger(root.left, key);
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        root.left = n1;
        root.right = new TreeNode(3);

        n1.left = new TreeNode(4);
        n1.right = new TreeNode(5);

        System.out.println(searchReturnInteger(root, 3));
    }

}
