package com.leetcode.graph

import com.ListNode

/**
 *
 * @author wezhyn
 * @since 06.14.2020
 *
 */


class ReverseLinkedListII {
    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        val newHead = ListNode(-1)
//        head 的前一个节点
        var pre = newHead
        var cur: ListNode? = head
        var index = 1
        loop@ while (true) {
            when (index) {
                in m..n -> {
                    if (cur == null) {
                        break@loop
                    }
                    val curNext: ListNode? = cur.next
                    pre.next = ListNode(cur.`val`, pre.next)
                    cur = curNext
                }
                else -> {
                    if (cur == null) {
                        break@loop
                    }
                    while (pre.next != null) {
                        pre = pre.next!!
                    }
                    pre.next = ListNode(cur.`val`)
                    pre = pre.next!!
                    cur = cur.next
                }
            }
            index++
        }
        return newHead.next
    }
}
