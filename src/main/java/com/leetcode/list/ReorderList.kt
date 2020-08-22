package com.leetcode.list

import com.ListNode


/**
 *
 * @author wezhyn
 * @since 08.21.2020
 *
 */
class ReorderList {
    fun reorderList(head: ListNode?): Unit {
        val m = mid(head) ?: return
        reverse(m)
        var h = head
        var l = m.next
        m.next = null
        val fakeHead = ListNode(-1)
        var cur = fakeHead
        while (h != null && l != null) {
            cur.next = h
            cur = h
            h = h.next
            cur.next = l
            cur = l
            l = l.next
        }
        if (h != null) {
            cur.next = h
        }
    }

    private fun reverse(head: ListNode) {
        var cur: ListNode? = head.next
        while (cur != null) {
            val next = cur.next
            if (head.next == cur) {
                cur.next = null
            } else {
                cur.next = head.next
            }
            head.next = cur
            cur = next
        }
    }

    // 返回中间节点, 偶数返回前一个，奇数返回中间
    private fun mid(head: ListNode?): ListNode? {

        var slow: ListNode? = head
        var fast: ListNode? = head?.next
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }
}