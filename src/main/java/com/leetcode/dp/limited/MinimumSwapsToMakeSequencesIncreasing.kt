package com.leetcode.dp.limited

/**
 *

We have two integer sequences `A` and `B` of the same non-zero length.

We are allowed to swap elements `A[i]` and `B[i]`.  Note that both elements are in the same index position in their respective sequences.

At the end of some number of swaps, `A` and `B` are both strictly increasing.  (A sequence is _strictly increasing_ if and only if `A[0] < A[1] < A[2] < ... < A[A.length - 1]`.)

Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that the given input always makes it possible.

```
Example:
Input: A = [1,3,5,4], B = [1,2,3,7]
Output: 1
Explanation:
Swap A[3] and B[3].  Then the sequences are:
A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
which are both strictly increasing.
```
 * 原想法是 A[0] ~ A[i-1] 是一个递增序列，B[0] ~ B[i-1] 是一个递增序列
 * 误区：如果 A[i-1] > A[i] 交换 B[i] 与 A[i] 虽然最后也能得到正确的解，但可能不是最优解
 * 如 A: [7,2,3,4] B: [1,7,8,9] 如果按照原思路，A[0] 与 B[0] 都是递增序列，虽然直接交换了 A[1] 与 B[1]
 * 使得 A[0-1] 是递增的，最终结果是 3 ，而交换A[0] 与 B[0] 只需要交换一次
 * 即 A[i-1] A[i] ，B[i-1] B[i] 两组之间有四种组合关系
 * 1. A0...A[i-1]A[i]
 * 2. A0...A[i-1]B[i]
 * 3. A0...B[i-1]A[i]
 * 4. A0...B[i-1]B[i]
 * @author wezhyn
 * @since 07.24.2020
 *
 */
class MinimumSwapsToMakeSequencesIncreasing {
    fun minSwap(A: IntArray, B: IntArray): Int {
//        swap[i-1][0]表示无交换 swap[i-1][1]表示i-1是与B[i-1]进行交换之后，使得A0-A[i]递增

        val swap = Array(A.size) { IntArray(2) { Int.MAX_VALUE } }
        swap[0][1] = 1
        swap[0][0] = 0
        for (i in 1 until A.size) {
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
//                1
                swap[i][0] = swap[i - 1][0]
//                2
                swap[i][1] = swap[i - 1][1] + 1
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
//                可能是 A[i-1]A[i] 也可能是 B[i-1]A[i]
                swap[i][0] = Math.min(swap[i][0], swap[i - 1][1])
//                A[i-1]B[i], B[i-1]B[i]
                swap[i][1] = Math.min(swap[i - 1][0] + 1, swap[i][1])
            }
        }
        return Math.min(swap[A.size - 1][0], swap[A.size - 1][1])
    }
}