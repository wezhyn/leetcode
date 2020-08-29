package com.leetcode.linked;

import java.util.Objects;

/**
 * @author wezhyn
 * @since 08.28.2020
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }


    public static ListNode create(int... nums) {
        ListNode h = new ListNode(-1), cur = h;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return h.next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o, cur = this;
        while (listNode != null && cur != null) {
            if (listNode.val != cur.val) {
                return false;
            }
            listNode = listNode.next;
            cur = cur.next;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
