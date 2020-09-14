package com.tecent;

/**
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @author wezhyn
 * @since 08.14.2020
 */
public class ReverseLinked {


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode h = new ListNode(-1, null), cur = h;
        h.next = head;
        int curIndex = 1;
//        保持原链表顺序
        while (curIndex < m) {
            cur = cur.next;
            curIndex++;
        }
        ListNode next = cur.next;
        ListNode fistNode = null;
        while (curIndex <= n && next != null) {
            if (curIndex == m) {
                fistNode = next;
            }
            ListNode nnext = next.next;
            next.next = cur.next;
            cur.next = next;
            next = nnext;
            curIndex++;
        }
        if (fistNode == null) {
            throw new IllegalArgumentException();
        }
        fistNode.next = next;
        return h.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                sb.append(cur.val)
                        .append("->");
                cur = cur.next;
            }
            return sb.toString();
        }
    }
}
