package com.wezhyn.learn.graph

import com.wezhyn.learn.ListNode


/**
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * @author wezhyn
 * @since 07.13.2020
 *
 */
class ReverseLinkedList {

    fun reverseList(head: ListNode?): ListNode? {
        var pre: ListNode? = null
        var cur: ListNode? = head
        while (cur != null) {
            val next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        }
        return pre
    }
}