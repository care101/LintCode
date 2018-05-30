package org.likexin.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * http://www.lintcode.com/en/problem/binary-tree-preorder-traversal/
 *
 * @author Shingo Lee
 */
public class PreorderTraversal {

  /**
   * 前序遍历：根左右，栈的特征是先入后出。并且注意对root的判空不能少，否则结果不对~
   *
   * @param root 二叉树根结点
   * @return 前序遍历集合
   */
  public List<Integer> preorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      result.add(node.val);

      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
    return result;
  }

}
