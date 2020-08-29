package com.leetcode.linked;

/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class ReverseNodeInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode h = new ListNode(-1), cur = h;
        h.next = head;
        ListNode nextGroup = head;
        while (nextGroup != null) {
            for (int i = 0; i < k; i++) {
                if (nextGroup == null) {
                    return h.next;
                }
                nextGroup = nextGroup.next;
            }
            ListNode tmp = null;
            for (ListNode c = cur.next; c != nextGroup; ) {
                ListNode cnext = c.next;
                c.next = cur.next;
                if (c.next == c) {
                    c.next = nextGroup;
                    tmp = c;
                }
                cur.next = c;
                c = cnext;
            }
            cur = tmp;
        }
        return h.next;
    }

}
