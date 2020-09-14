package com.wezhyn.learn.lcof

import java.util.*
import kotlin.collections.ArrayList

/**
 * 滑动窗口
 * 难点在于窗口的前进过程中，如何获取当前窗口内的最大值
 * 1. 扫描窗口内的全部元素
 * 2. 使用一个队列保存最大值和其他候选者
 * @author wezhyn
 * @since 07.18.2020
 *
 */
class SlidingWindowMaximum {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.size < k) {
            return intArrayOf()
        }
        val result = ArrayList<Int>()
//        最多只有k-1个元素，至少一个
        val queue = LinkedList<Pair<Int, Int>>().apply {
            offer(Pair(-1, Int.MIN_VALUE))
        }
        for ((i, n) in nums.withIndex()) {
//            当前队列的最大值和候选者由当前元素进行替换
            val maxIterator = queue.listIterator()
            while (maxIterator.hasNext()) {
//            去除过期Max
                val curMax = maxIterator.next()
                if (i - curMax.first >= k) {
                    maxIterator.remove()
                    continue
                }
//                找到第一个比当前元素大的元素
                if (n >= curMax.second) {
//                    去除当前元素之后的全部候选元素
                    maxIterator.remove()
                    while (maxIterator.hasNext()) {
                        maxIterator.next()
                        maxIterator.remove()
                    }
                    break
                }
            }
            maxIterator.add(Pair(i, n))
            if (i >= k - 1) {
                result.add(queue.peek().second)
            }
        }
        return result.toIntArray()
    }
}