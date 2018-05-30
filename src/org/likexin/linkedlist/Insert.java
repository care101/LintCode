package org.likexin.linkedlist;

/**
 * http://www.lintcode.com/en/problem/insert-into-a-cyclic-sorted-list/
 *
 * @author Shingo Lee
 */
public class Insert {

  /**
   * 主要是要考虑到所有的case，有如下四种情况：
   * 1. node为空，那么需要返回x节点并且x节点再指向自己，保证循环起来。
   * 2. node.val > node.next.val，假如 node.val < x < node.next.val，那么直接将x节点插入并返回。
   * 3. node.val < node.next.val，这时说明node是链表的尾节点，如果 node.val > x && node.next.val > x，那么直接将x节点插入并返回。
   * 4. node.val == node.next.val，如果node是链表的尾节点，那么直接将x节点插入并返回。
   * <p>
   * 另外，insertNode()方法是插入节点方法，可以记住一下。
   * <p>
   * 参考：https://yeqiuquan.blogspot.ca/2017/04/lintcode-599-insert-into-cyclic-sorted.html
   *
   * @param node 链表头节点
   * @param x    目标节点
   * @return 排好序的循环链表
   */
  public ListNode insert(ListNode node, int x) {
    // case 1: node == null
    if (node == null) {
      node = new ListNode(x);
      node.next = node;
      return node;
    }


    ListNode head = node;
    while (node != null && node.next != null) {
      if (node.val < node.next.val) { // case 2(x = 4): 3 -> 4 -> 5 -> 1
        if (node.val <= x && x <= node.next.val) {
          insertNode(node, x);
          break;
        }
      } else if (node.val > node.next.val) { // case 3(x = 0): 3 -> 5 -> 0 -> 1
        if (node.val >= x || node.next.val >= x) {
          insertNode(node, x);
          break;
        }
      } else { // node.val == node.next.val
        if (node.next == head) {
          insertNode(node, x);
          break;
        }
      }
      node = node.next;
    }
    return head;
  }

  private void insertNode(ListNode node, int x) {
    ListNode newNode = new ListNode(x);
    newNode.next = node.next;
    node.next = newNode;
  }

}
