package org.likexin.linkedlist;

/**
 * http://www.lintcode.com/en/problem/merge-two-sorted-lists/
 *
 * @author Shingo Lee
 */
public class MergeTwoLists {

    /**
     * 思路主要分为两点：
     *  1. 使用dummy node，因为在合并的过程中链表的结构会发生变化，所以需要一个dummy node来保证头节点的不变。到时候直接返回dummy.next。
     *  2. 在一个while循环中，依次移动指针来比较每一位的大小，将其连接起来。
     *
     * @param l1 链表l1的头节点
     * @param l2 链表l2的头节点
     * @return 合并后的有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode newNode = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                newNode.next = l2;
                l2 = l2.next;
            } else {
                newNode.next = l1;
                l1 = l1.next;
            }
        }

        if (l1 != null) {
            newNode.next = l1;
        } else {
            newNode.next = l2;
        }
        return dummy.next;
    }

}
