/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */


/**
 * e.g:
 * assume delete node is 7
 * 4 -> 5 -> 7 -> 9 ===> 4 -> 5 -> 9 -> 9 ===> 4 -> 5 -> 9
 * 
 * @param {ListNode} node
 * @return {void} Do not return anything, modify node in-place instead.
 */
var deleteNode = function(node) {
  node.val = node.next.val;
  node.next = node.next.next;
};