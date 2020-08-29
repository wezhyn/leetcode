package com.leetcode.linked;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * Input: 1->2->3->4
 * Output: 2->1->4->3
 *
 * @author wezhyn
 * @since 04.11.2020
 */
public class SwapNodesInPairs {


    public ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode(-1), cur = head, pre = h;
        h.next = head;
        while (cur != null && cur.next != null) {
            ListNode cnn = cur.next.next, cn = cur.next;
            pre.next = cn;
            cn.next = cur;
            cur.next = cnn;
            pre = cur;
            cur = cnn;
        }
        return h.next;
    }
}
