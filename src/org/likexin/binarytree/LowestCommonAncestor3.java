package org.likexin.binarytree;

/**
 * http://www.lintcode.com/en/problem/lowest-common-ancestor-iii/
 *
 * @author Shingo Lee
 */
public class LowestCommonAncestor3 {

    private class ResultType {
        public boolean a_exist;
        public boolean b_exist;
        public TreeNode node;
        public ResultType(TreeNode node, boolean a, boolean b) {
            this.a_exist = a;
            this.b_exist = b;
            this.node = node;
        }
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        ResultType result = helper(root, A, B);
        if (result.b_exist && result.a_exist) {
            return result.node;
        } else {
            return null;
        }
    }

    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(null, false, false);
        }

        ResultType left_rt = helper(root.left, A, B);
        ResultType right_rt = helper(root.right, A, B);

        boolean a_exist = left_rt.a_exist || right_rt.a_exist || root == A;
        boolean b_exist = left_rt.b_exist || right_rt.b_exist || root == B;

        if (A == root || B == root) {
            return new ResultType(root, a_exist, b_exist);
        }
        // case 1
        if (left_rt.node != null && right_rt.node != null) {
            return new ResultType(root, a_exist, b_exist);
        }
        // case 2
        if (left_rt.node != null) {
            return new ResultType(root.left, a_exist, b_exist);
        }
        // case 3
        if (right_rt.node != null) {
            return new ResultType(root.right, a_exist, b_exist);
        }
        return new ResultType(null, a_exist, b_exist);
    }

}

