package com.code.baijiahulian;

/**
 * @author wezhyn
 * @since 08.07.2020
 */
public class LinkedMerge {

    public Node mergeTwoLists(Node n1, Node n2) {
        Node head = new Node();
        Node cur = head;
        while (n1 != null && n2 != null) {
            Node next;
            if (n1.data < n2.data) {
                next = n1.next;
                n1.next = null;
                cur.next = n1;
                n1 = next;
            } else {
                next = n2.next;
                n2.next = null;
                cur.next = n2;
                n2 = next;
            }
            cur = cur.next;
        }
        if (n1 == null) {
            cur.next = n2;
        } else {
            cur.next = n1;
        }
        return head.next;
    }
}

class Node {
    int data;
    Node next;
}
