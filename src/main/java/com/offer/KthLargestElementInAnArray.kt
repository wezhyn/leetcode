package com.offer

import com.FixedPriorityQueue
import java.util.*

/**
 *
 * @author wezhyn
 * @since 07.03.2020
 *
 */
class KthLargestElementInAnArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heap = FixedPriorityQueue<Int>(PriorityQueue(), k)
        nums.forEach { heap.offer(it) }
        return heap.peek()

    }
}