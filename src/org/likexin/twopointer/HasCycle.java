package org.likexin.twopointer;

public class HasCycle {

  /**
   * 使用快慢指针，如果链表有环，那么slow和fast总会相遇的。
   * @param head
   * @return
   */
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }

    ListNode slow = head, fast = head.next;
    while (fast.next != null && fast != null) {
      if (slow == fast) {
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }
}
