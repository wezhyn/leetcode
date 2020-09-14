package com.wezhyn.learn.lcof

import com.wezhyn.learn.ListNode

/**
 * 通过快慢指针查找
 *
 * 快：走两步
 * 慢：走一步
 *
 * @author wezhyn
 * @since 06.30.2020
 *
 */
class LinkedListCycleII {

    fun detectCycle(head: ListNode?): ListNode? {
        var fastPointer = head
        var slowPointer = head
        while (true) {
            fastPointer = fastPointer?.next?.next
            slowPointer = slowPointer?.next
            if (fastPointer === null) {
                return null
            }
            if (fastPointer === slowPointer) {
                break
            }
        }
        slowPointer = head
        while (slowPointer !== fastPointer) {
            slowPointer = slowPointer?.next
            fastPointer = fastPointer?.next
        }
        return slowPointer
    }
}