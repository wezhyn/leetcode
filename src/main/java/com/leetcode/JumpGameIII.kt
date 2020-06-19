package com.leetcode

import com.oneDimensional
import com.runTime

/**
 *  dp(i) -> dp(i+arr[i])|| dp(i-arr[i])
 * @author wezhyn
 * @since 06.18.2020
 *
 */

fun main() = runTime {
    JumpGameIII().canReach("[4,2,3,0,3,1,2]".oneDimensional().toIntArray(), 5).apply(System.out::println)
//    JumpGameIII().canReach("[4,2,3,0,3,1,2]".oneDimensional().toIntArray(), 0).apply(System.out::println)
//    JumpGameIII().canReach("[3,0,2,1,2]".oneDimensional().toIntArray(), 2).apply(System.out::println)
}

class JumpGameIII {

    private val cache = HashMap<Int, Boolean?>()
    fun canReach(arr: IntArray, start: Int): Boolean {
        if (start < 0 || start > arr.size - 1) {
            return false
        } else if (arr[start] == 0) {
            return true
        }
        val mapStart = cache.get(start)
        if (mapStart == null) {
            cache[start] = false
            val result = canReach(arr, start + arr[start]) || canReach(arr, start - arr[start])
            if (result) {
                cache[start] = true
            }
            return result
        }
        return mapStart
    }
}