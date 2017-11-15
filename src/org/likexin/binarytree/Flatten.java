package org.likexin.binarytree;

/**
 * http://www.lintcode.com/en/problem/flatten-binary-tree-to-linked-list/
 *
 * @author Shingo Lee
 */
public class Flatten {

    private TreeNode lastNode = null;

    /**
     * Traverse
     * @param root 二叉树根结点
     */
    public void flatten_solution1(TreeNode root) {
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right = root.right;
        flatten_solution1(root.left);
        flatten_solution1(right);
    }

    /**
     * Divide & Conquer
     * @param root 二叉树根结点
     */
    public void flatten_solution2(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);

        // connect leftLast to root.right
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (rightLast != null) {
            return rightLast;
        }

        if (leftLast != null) {
            return leftLast;
        }

        return root;
    }

}
