package com.offer

/**
 * 给定一个一维数组，重排序数组，使得全部偶数在奇数之前
 * @author wezhyn
 * @since 06.30.2020
 *
 */
class SortArrayByParity {
    fun sortArrayByParity(A: IntArray): IntArray {
//        [0,l] 代表偶数区间，(l,r]代表奇数区间
        var l = -1
        var r = -1
        if (A.isEmpty()) {
            return A
        }
        while (r + 1 < A.size && l + 1 < A.size) {
            val nextL = A[l + 1]
            if (nextL.and(1) == 0) {
                l++
            } else {
                while (r + 1 < A.size) {
                    val nextR = A[r + 1]
                    if (r > l && nextR.and(1) == 0) {
                        break
                    }
                    r++
                }
                if (r + 1 >= A.size) {
                    break
                }
                A[++l] = A[r + 1]
                A[++r] = nextL
            }
        }
        return A
    }
}