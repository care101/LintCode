package org.likexin.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * http://www.lintcode.com/en/problem/binary-tree-postorder-traversal/
 *
 * @author Shingo Lee
 */
public class PostorderTraversal {

    /**
     * 后序遍历：左右根
     *
     * @param root 二叉树根结点
     * @return 后序遍历集合
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode curr = root;

        if (root == null) {
            return result;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        return result;
    }
}
