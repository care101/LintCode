package org.likexin.binarytree;

/**
 * http://www.lintcode.com/en/problem/maximum-depth-of-binary-tree/
 *
 * @author Shingo Lee
 */
public class MaxDepth {

    /**
     * 左右递归，注意最后应该把根结点加上。
     *
     * @param root 二叉树根结点
     * @return 二叉树的深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
