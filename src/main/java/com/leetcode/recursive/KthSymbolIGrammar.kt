package com.leetcode.recursive

/**
 * On the first row, we write a 0.
 * Now in every subsequent row, we look at the previous row and replace
 * each occurrence of 0 with 01, and each occurrence of 1 with 10
 *
 * Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).
 * Examples:
Input: N = 1, K = 1
Output: 0

Input: N = 2, K = 1
Output: 0

Input: N = 2, K = 2
Output: 1

Input: N = 4, K = 5
Output: 1

Explanation:
row 1: 0
row 2: 01
row 3: 0110
row 4: 01101001
 * 一道明显的递归题，Kth 上的位置取决于 N-1 row 上对应的父xth 是0还是 1，之后01 10 和当前k的 奇偶性进行判断
 * 由于k 从 1开始，第 Kth index 的父 index = (K+1)/2
 * @author wezhyn
 * @since 08.18.2020
 *
 */
class KthSymbolIGrammar {
    fun kthGrammar(N: Int, K: Int): Int {
        if (N == 1) {
            return 0
        }
        val parent = kthGrammar(N - 1, (K + 1) / 2)
//        0 -> 当前为 01 1 -> 当前为 10
        return if (K.and(1) == 0) {
            1 - parent
        } else {
            parent
        }

    }
}