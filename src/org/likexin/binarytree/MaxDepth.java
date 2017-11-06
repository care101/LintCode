package org.likexin.binarytree;

/**
 * http://www.lintcode.com/en/problem/maximum-depth-of-binary-tree/
 *
 * @author Shingo Lee
 */
public class MaxDepth {

    /**
     * (分治法) 左右递归，注意最后应该把根结点加上。
     *
     * @param root 二叉树根结点
     * @return 二叉树的深度
     */
    public int maxDepth_DivideConquer(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    private int depth;

    /**
     * (遍历法) 左右递归，注意最后应该把根结点加上。
     *
     * @param root 二叉树根结点
     * @return 二叉树的深度
     */
    public int maxDepth_Traverse(TreeNode root) {
        depth = 0;
        helper(root, 1);
        return depth;
    }

    private void helper(TreeNode node, int curtDepth) {
        if (node == null) {
            return;
        }
        if (curtDepth > depth) {
            depth = curtDepth;
        }

        helper(node.left, curtDepth + 1);
        helper(node.right, curtDepth + 1);
    }

}
