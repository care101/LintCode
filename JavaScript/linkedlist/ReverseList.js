/**
 * Four steps:
 * 
 * c = h, p = null   n = c.next       c.next = p      p = c            c = n
 * 1 -> 2 -> 3   =>  1 -> 2 -> 3  =>  1   2 -> 3  =>  1    2 -> 3  =>  1    2 ->3
 * |                 |    |           |   |           |    |           |    |
 * c                 c    n           c   n           p,c  n           p    c
 * 
 * @param head: n
 * @return: The new head of reversed linked list.
 */
const reverse = function (head) {
  if (head === null) return null;
  let curr = head;
  let prev = null;
  
  while (curr !== null) {
    let next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
  }
  return prev;
}