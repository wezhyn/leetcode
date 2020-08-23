package com.random

/**
 *
 * @author wezhyn
 * @since 08.22.2020
 *
 */
class SortArrayByParity {

    fun sortArrayByParity(A: IntArray): IntArray {
        var l = 0
        var r = A.size - 1
        while (l < r) {
            while (l <= A.size - 1 && A[l].and(1) == 0) {
                l++
            }
            while (r >= 0 && A[r].and(1) == 1) {
                r--
            }
            if (l >= r) {
                break
            }
            val tmp = A[l]
            A[l] = A[r]
            A[r] = tmp
            l++
            r--
        }
        return A
    }
}