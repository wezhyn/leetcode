package com.leetcode.top.interview.medium;

import com.leetcode.top.interview.ListNode;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 04.11.2020
 */
public class RemoveNthNodeFromEndOfList {

    @Test
    public void test() {
        System.out.println(removeNthFromEnd(new ListNode(1),1));
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=head, fast=head;

        while (n > 0) {
            if (fast!=null) {
                fast=fast.next;
                n--;
            }else {
                break;
            }
        }
        if (n > 0) {
//            当前无效
        } else if (fast==null&&n==0) {
            return head.next;
        } else if (fast!=null) {
            fast=fast.next;
        }
        while (fast!=null) {
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
