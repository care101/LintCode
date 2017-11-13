package org.likexin.binarytree;

/**
 * http://www.lintcode.com/zh-cn/problem/minimum-subtree/
 *
 * @author Shingo Lee
 */
public class FindSubtree {

    private TreeNode subtree = null;
    private int subtreeSum = Integer.MAX_VALUE;

    /**
     * Traverse + Divide Conquer
     *
     * @param root 二叉树根结点
     * @return 和最小的子树的根结点
     */
    public TreeNode findSubtree_solution1(TreeNode root) {
        helper1(root);
        return subtree;
    }

    private int helper1(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int sum = helper1(node.left) + helper1(node.right) + node.val;
        if (sum <= subtreeSum) {
            subtreeSum = sum;
            subtree = node;
        }
        return sum;
    }

    /**
     * Pure Divide Conquer
     *
     * @param root 二叉树根结点
     * @return 和最小的子树的根结点
     */
    public TreeNode findSubtree_solution2(TreeNode root) {
        ResultType resultType = helper2(root);
        return resultType.minSubtree;
    }

    private ResultType helper2(TreeNode node) {
        if (node == null) {
            return new ResultType(null, Integer.MAX_VALUE, 0);
        }

        ResultType leftResult = helper2(node.left);
        ResultType rightResult = helper2(node.right);
        ResultType result = new ResultType(node,
                leftResult.sum + rightResult.sum + node.val,
                leftResult.sum + rightResult.sum + node.val);

        if (leftResult.minSum <= result.minSum) {
            result.minSum = leftResult.minSum;
            result.minSubtree = leftResult.minSubtree;
        }

        if (rightResult.minSum <= result.minSum) {
            result.minSum = rightResult.minSum;
            result.minSubtree = rightResult.minSubtree;
        }
        return result;
    }

}

class ResultType {
    public TreeNode minSubtree;
    public int sum, minSum;
    public ResultType(TreeNode minSubtree, int minSum, int sum) {
        this.minSubtree = minSubtree;
        this.sum = sum;
        this.minSum = minSum;
    }
}