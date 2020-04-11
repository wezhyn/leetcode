package com.leetcode.top.interview.medium;

import com.leetcode.top.interview.ListNode;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 04.11.2020
 */
public class SwapNodesInPairs {

    @Test
    public void test() {
        ListNode node=new ListNode(1);
        node.next=new ListNode(4);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        ListNode.traverse(swapPairs(node));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode cur=head;
        ListNode pre=new ListNode(-1);
        head=pre;
        pre.next=cur;
        while (cur!=null && cur.next!=null) {
            ListNode next=cur.next;
            pre.next=next;
            cur.next=next.next;
            next.next=cur;
            pre=cur;
            cur=cur.next;
        }
        return head.next;
    }
}
