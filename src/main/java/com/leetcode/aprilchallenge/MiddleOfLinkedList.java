package com.leetcode.aprilchallenge;

import com.leetcode.top.interview.ListNode;

/**
 * 快慢指针真厉害
 *
 * @author wezhyn
 * @since 04.08.2020
 */
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
