package com.wezhyn.learn.lcof

import com.wezhyn.learn.ListNode

/**
 * 使用双指针策略，让第二个指针领先第一个指针n步
 * 给定的 N 是一直有效的
 *
 * 为了使得n =arr-1 和 n=arr-2 操作相同，添加一个伪头节点
 *
 * @author wezhyn
 * @since 06.30.2020
 *
 */
class RemoveNthNodeFromEndOfList {


    fun removeNthFromEnd(_head: ListNode?, _n: Int): ListNode? {
        val head = ListNode(-1).apply { next = _head }
        var n = _n
        var prePointer = head
        var cur = head
        while (n > 0 && head.next != null) {
            prePointer = prePointer.next!!
            n--
        }
        while (prePointer.next != null) {
            prePointer = prePointer.next!!
            cur = cur.next!!
        }
        cur.next = cur.next?.next
        return head.next
    }

}