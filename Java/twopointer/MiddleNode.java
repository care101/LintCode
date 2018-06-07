package org.likexin.twopointer;

public class MiddleNode {

  /**
   * 快慢指针，慢指针每次走一步，快指针每次走两步。当快指针指向链表尾部时慢指针刚好在中点。
   */
  public ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode slow = head, fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

}
