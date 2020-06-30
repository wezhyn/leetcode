package com.leetcode.top.interview.medium;

import com.ListNode;

/**
 * @author wezhyn
 * @since 04.11.2020
 */
public class SwapNodesInPairs {


    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        ListNode pre = new ListNode(-1);
        head = pre;
        pre.setNext(cur);
        while (cur != null && cur.getNext() != null) {
            ListNode next = cur.getNext();
            pre.setNext(next);
            cur.setNext(next.getNext());
            next.setNext(cur);
            pre = cur;
            cur = cur.getNext();
        }
        return head.getNext();
    }
}
