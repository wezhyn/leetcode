package com

import java.util.*

/**
 * 传入最小堆，返回整体后最大的元素
 * 传入最大堆，返回整体最小的元素
 * @author wezhyn
 * @since 07.03.2020
 *
 */
class FixedPriorityQueue<T : Comparable<T>>(val queue: PriorityQueue<T>, private val maxSize: Int) : Queue<T> by queue {

    private val comparator = queue.comparator() ?: Comparator.naturalOrder()

    override fun add(element: T): Boolean {
        return this.offer(element)
    }

    override fun offer(e: T): Boolean {

        when {
            queue.size < maxSize -> {
                queue.offer(e)
//            原队列的排序，如果原序列采用的是最小堆，queue.peek()返回的是最小的 ，一步步去除最小的，整体最后是序列的最大值
//            如果是最大堆，peek()返回最大值，一步步去除最大值，整体最小
            }
            comparator.compare(e, queue.peek()) > 0 -> {
                queue.poll()
                queue.offer(e)
            }
            else -> {
                return false
            }
        }
        return true
    }
}