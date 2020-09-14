package com.wezhyn.learn.lcof

import java.util.*
import kotlin.collections.ArrayList

/**
 *
 * 全排列
 * 1，2，3->
 * 1，2，3，
 * 1，3，2，
 * 2，1，3，
 * 2，3，1
 * 3，1，2
 * 3，2，1
 * @author wezhyn
 * @since 07.01.2020
 *
 */
class Permutations {

    private lateinit var result: MutableList<List<Int>>

    fun permute(nums: IntArray): List<List<Int>> {
        result = ArrayList()
        backtrack(nums.toCollection(LinkedList()), 0, IntArray(nums.size))
        return result
    }

    private fun backtrack(nums: Queue<Int>, index: Int, prepare: IntArray) {
        if (index >= prepare.size) {
            result.add(prepare.toList())
        }
        for (i in index until prepare.size) {
            val cur = nums.poll()
            prepare[index] = cur
            backtrack(nums, index + 1, prepare)
            nums.offer(cur)
        }
    }
}