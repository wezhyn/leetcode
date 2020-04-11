package com.leetcode.top.interview;

/**
 * @author wezhyn
 * @since 03.10.2020
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val=x;
    }

    public static void traverse(ListNode node) {
        StringBuilder sb=new StringBuilder();
        while (node!=null) {
            sb.append(node.val).append(", ");
            node=node.next;
        }
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
