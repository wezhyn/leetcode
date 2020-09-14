package com.wezhyn.learn.backtracking

/**
 *
 * Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.

Note that every number in the answer must not have leading zeros except for the number 0 itself.
For example, 01 has one leading zero and is invalid, but 0 is valid.
Input: N = 3, K = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes
 * @author wezhyn
 * @since 08.19.2020
 *
 */
class NumbersWithSameConsecutiveDifferences {

    private lateinit var results: MutableSet<Int>
    fun numsSameConsecDiff(N: Int, K: Int): IntArray {
        results = HashSet()
        backtracking(IntArray(N), 0, K)
        return results.toIntArray()
    }

    private fun backtracking(arr: IntArray, i: Int, K: Int) {
        if (i >= arr.size) {
            results.add(arrToInt(arr))
            return
        }
        if (i == 0) {
            for (j in 0..9) {
                arr[i] = j
                if (j == 0 && arr.size != 1) {
                    continue
                }
                backtracking(arr, i + 1, K)
            }
        } else {
            val pre = arr[i - 1]
            if ((pre + K) < 10) {
                arr[i] = pre + K
                backtracking(arr, i + 1, K)
            }
            if ((pre - K) >= 0) {
                arr[i] = pre - K
                backtracking(arr, i + 1, K)
            }
        }
    }

    private fun arrToInt(arr: IntArray): Int {
        var result = 0
        for (v in arr) {
            result *= 10
            result += v
        }
        return result
    }

}