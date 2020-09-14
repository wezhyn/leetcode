package com.wezhyn.learn.linked;

/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class DeleteNodeInALinkedList {


    public void deleteNode(ListNode node) {
        ListNode cNext = node.next;
        if (cNext == null) {
            throw new IllegalArgumentException("无效的参数");
        }
        node.val = cNext.val;
        node.next = cNext.next;
    }
}
