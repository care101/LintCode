/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
  let dummy = new ListNode(0);
  let curr = dummy;
  while (l1 !== null && l2 !== null) {
    if (l1.val > l2.val) {
      curr.next = l2;
      l2 = l2.next;
    } else {
      curr.next = l1;
      l1 = l1.next;
    }
    curr = curr.next;
  }
  while (l1 !== null) {
    curr.next = l1;
    l1 = l1.next;
    curr = curr.next;
  }
  while (l2 !== null) {
    curr.next = l2;
    l2 = l2.next;
    curr = curr.next;
  }
  return dummy.next;
};