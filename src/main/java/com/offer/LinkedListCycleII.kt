package com.offer

import com.ListNode

/**
 * 通过快慢指针查找
 *
 * 快：走两步
 * 慢：走一步
 *
 * 若存在一个环，则快指针最后会追上, 快指针会在慢指针走完到第一个环之前结束【第一个循环】
 * 假设目前存在一个环  头节点-> x 步 -> 环头节点 -> y1 步 都两者相遇 y2 步到达环头节点
 * 快指针走过的路程= x + y1 +y2 + y1
 * 慢指针走过的路程= x+ y1
 * 可以得出 x= y2
 * 所以当一个节点从头节点出发走 x 步 ，和在相遇点走x 步，就会到达 环头节点【第二个循环】
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