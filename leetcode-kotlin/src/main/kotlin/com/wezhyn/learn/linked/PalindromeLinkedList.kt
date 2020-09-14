package com.wezhyn.learn.linked

import com.wezhyn.learn.ListNode

/**
 * Input: 1->2->2->1
 * Output: true
 *
 * 快慢指针搜索中间节点
 *
 * @author wezhyn
 * @since 07.14.2020
 *
 */
class PalindromeLinkedList {
    fun isPalindrome(head: ListNode?): Boolean {
        var mid: ListNode = middle(head ?: return true)
        if (mid === head && mid.next == null) {
//            单节点
            return true
        }
        reverse(mid)

        var h: ListNode = ListNode(
            -1
        ).apply { next = head }
        while (mid.next != null && h.next != null) {
            mid = mid.next!!
            h = h.next!!
            if (mid.`val` != h.`val`) {
                return false
            }
        }
        return true
    }

    private fun reverse(head: ListNode) {
        val firstNext = head.next
        var cur = firstNext
        while (cur != null) {
            val next = cur.next
            cur.next = head.next
            head.next = cur
            cur = next
        }
        firstNext?.next = null
    }

    /**
     * 奇数返回中间，偶数返回 前一个元素
     */
    private fun middle(head: ListNode): ListNode {
        var slow = head
        var fast = head.next
        while (fast?.next != null) {
            slow = slow.next!!
            fast = fast.next?.next
        }
        return slow
    }
}