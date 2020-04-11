package com.leetcode.top.interview.easy;

/**
 * @author wezhyn
 * @since 04.03.2020
 */
public class MergeTwoSortedLists {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ll=l1;
        ListNode lr=l2;
        ListNode head=new ListNode(-1), guard=head;
        while (ll!=null && lr!=null) {
            int nl=ll.val;
            int nr=lr.val;
            if (nl > nr) {
                head.next=new ListNode(nr);
                lr=lr.next;
            } else {
                head.next=new ListNode(nl);
                ll=ll.next;
            }
            head=head.next;
        }
        ListNode ls=ll==null ? lr : ll;
        while (ls!=null) {
            head.next=new ListNode(ls.val);
            head=head.next;
            ls=ls.next;
        }
        return guard.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val=x;
        }
    }
}
