package com.wezhyn.learn.dp

/**
 * 使用 dp[i] 表示 从第0 个加到第 i个元素之和
 * @author wezhyn
 * @since 06.23.2020
 *
 */
class NumArray(val nums: IntArray) {


//    private  val dp = Array(nums.size) { IntArray(nums.size) }

    private val dp = IntArray(nums.size)

    fun sumRange(i: Int, j: Int): Int {
        return dp[j] - dp[i] + nums[i]
    }

    init {
        val arrLen = nums.size - 1
        if (arrLen >= 0) {
            dp[0] = nums[0]
        }
        for (i in 1..arrLen) {
            dp[i] = dp[i - 1] + nums[i]
        }


//        二维数组 :Memory Exceeded
//        for (step in 0..arrLen) {
//            val maxI = arrLen - step
//            for (mi in 0..maxI) {
//                val mj = mi + step
//                if (mj == mi) {
//                    dp[mi][mj] = nums[mi]
//                } else {
//                    dp[mi][mj] = nums[mi] + dp[mi + 1][mj]
//                }
//            }
//        }
    }


}

