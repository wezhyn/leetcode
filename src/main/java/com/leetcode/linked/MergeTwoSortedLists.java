package com.leetcode.linked;

/**
 * @author wezhyn
 * @since 04.03.2020
 */
public class MergeTwoSortedLists {


    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        ListNode h = new ListNode(-1), ch = h;
//       	首先对两个链表进行遍历，将较小元素链接到h上
        ListNode ch1 = h1, ch2 = h2;
        while (ch1 != null && ch2 != null) {
            ListNode select = ch1.val < ch2.val ? ch1 : ch2;
            ListNode next = select.next;
            ch.next = select;
            ch = select;
            select.next = null;
            if (ch1.val < ch2.val) {
                ch1 = next;
            } else {
                ch2 = next;
            }
        }
        if (ch1 != null) {
            ch.next = ch1;
        } else {
            ch.next = ch2;
        }
        return h.next;
    }

}
