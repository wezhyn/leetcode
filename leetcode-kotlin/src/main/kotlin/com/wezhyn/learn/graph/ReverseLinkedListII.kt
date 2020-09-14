package com.wezhyn.learn.graph

import com.wezhyn.learn.ListNode


/**
 *
 * @author wezhyn
 * @since 06.14.2020
 *
 */


class ReverseLinkedListII {
    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        val h = ListNode(-1)
        var pre: ListNode = h
        var cur: ListNode = head ?: return null
        var index = 1
        var mNode: ListNode? = null
        while (true) {
            when (index) {
                in m..n -> {
                    if (index == m) {
                        mNode = cur
                    }
                    val next = cur.next
                    cur.next = pre.next
                    pre.next = cur
                    if (next == null || index == n) {
//                        当获取到最后一个节点时，将第一个m 的next指向m的下一个元素
                        mNode?.next = next
                        if (next == null) {
                            return h.next
                        }
                        pre = mNode!!
                    }
                    cur = next
                }
                else -> {
                    val next = cur.next ?: return h.next
                    pre.next = cur
                    pre = cur
                    cur = next
                }
            }
            index++
        }
    }
}
