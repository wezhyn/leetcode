package com.leetcode.dp

/**
 * 跟常见的DP不同，从示例的流程中无法发现正常的拆分子流程细节
 * 题目：
 * Given n balloons, indexed from 0 to n-1.
 * Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons.
 * If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * Example1：
 * Input: [3,1,5,8]
 *  Output: 167
 *  Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *  coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * > 给定条件，最大数量n 为500，所以最大时间复杂度不能超过 n^3 (纯3次方也过大)
 *
 *
 *  [3,1,5,8] 爆破1后，变成 [3,5,8] ; 爆破 5的 [3，1，8] 无法发现一个正常的子序列，虽然可以尝试使用 1011代表未爆破的序列，
 *  但也需要 2^n 的可能性，较难发现当前 1011 与 1001 或者 0011 或者其他序列之间的关系
 *
 *  当逆向去思考，尝试保留 1 得[3][1][5,8] 得到了两个相关得子序列 ，dp(i,j)= 尝试在当前范围内保存一个K 不进行爆破，爆破其左边
 *  和右边，获取最大值
 *  dp(i,j)=Max(dp(i,j),dp(i,k)+arr[i-1]*arr[k]*arr[j+1]+dp(k+1,j)
 *  > [i,j] 非 [i,j)
 *
 * @author wezhyn
 * @since 06.23.2020
 *
 */
class BurstBalloons {

    fun maxCoins(nums: IntArray): Int {
        val arrLen = nums.size - 1
        val dp = Array(arrLen + 1) { IntArray(arrLen + 1) { 0 } }
        for (step in 0..arrLen) {
            val maxI = arrLen - step
            for (i in 0..maxI) {
//                需要遍历该 (i,j) 范围内可以暂时不爆破的K
                val j = i + step
                for (k in i..j) {
//                    i==j 时，两边 dp[i][k-1] 为0
                    dp[i][j] = Math.max(getDp(dp, i, j),
                            getDp(dp, i, k - 1) + getArr(nums, i - 1) * getArr(nums, k) * getArr(nums, j + 1) + getDp(dp, k + 1, j)
                    )
                }
            }
        }
        return dp[0][arrLen]
    }

    private fun getDp(dp: Array<IntArray>, i: Int, j: Int): Int {
        if (j < 0 || i >= dp.size) {
            return 0
        }
        return dp[i][j]
    }

    private fun getArr(nums: IntArray, i: Int): Int {
        if (i >= nums.size || i < 0) {
            return 1
        }
        return nums[i]
    }
}