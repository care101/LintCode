package org.likexin.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * http://www.lintcode.com/en/problem/binary-tree-inorder-traversal/
 *
 * @author Shingo Lee
 */
public class InorderTraversal {

  /**
   * 中序遍历：左根右，栈的特征是先入后出。
   *
   * @param root 二叉树根结点
   * @return 中序遍历集合
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> result = new ArrayList<>();
    TreeNode curr = root;

    while (curr != null || !stack.empty()) {
      while (curr != null) {
        stack.add(curr);
        curr = curr.left;
      }
      stack.pop();
      result.add(curr.val);
      curr = curr.right;
    }
    return result;
  }

}
