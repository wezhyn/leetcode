package com.wezhyn.learn.linked;


/**
 * @author wezhyn
 * @since 08.28.2020
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        ListNode h = new ListNode(-1), slow = h, fast = h;
        h.next = head;
        for (int i = 0; i < n && fast != null; i++) {
//            前进n个
            fast = fast.next;
        }
//        n 超出范围
        if (fast == null) {
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return h.next;
    }
}
