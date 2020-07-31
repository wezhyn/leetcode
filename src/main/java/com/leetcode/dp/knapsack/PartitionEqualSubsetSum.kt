package com.leetcode.dp.knapsack

import java.util.*
import kotlin.collections.HashMap

/**
 *

Given a **non-empty** array containing **only positive integers**,
find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 **Note:**

1.  Each of the array element will not exceed 100.
2.  The array size will not exceed 200.

 **Example 1:**

```
Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
```

 **Example 2:**

```
Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
```
 * 将 nums 划分成两个相等的数组，即隐含着一个隐式条件：其中一个数组的元素和为总和的一半【我真是天生愚钝】
 * 这样就退化成了 0-1背包问题，给定一个Num，找到一个数组满足和为 num
 *
 * I(N) S(N<sup>2</sup>) D(1)
 * dp(i,j) 即 nums[0..i] 是否有数组满足和为 j
 *
 * dp(i,j) = dp(i-1,j-n) || dp(i-1,j)  即第 i 个元素可以选也可以不选
> n:=nums[i]
 * 给定条件 最大sum= 200*100 ，最大元素200,所以总操作为 200*100/2 轮 即 10000
 *
 *        dp 的作用主要是找到一个何为 sum 的值,但可以通过一维数组进行实现,取 1 5 5 11 为例        {0}
 *                                                                                      {0，1}
 *                                                                                      {0，1，5，6}
 *                                                                                      {0，1，5，6，10，11}
 *        找到 11已经可以停止
 *
 * 0-1 背包 二维模板
 * for i = 1 to N :
 *     for j = 0 to W:
 *         dp[i][j]= xxx
 *
 * 0-1 背包 一维模板
 * for i = i to N:
 *     w=nums[i]
 *     // 值得注意的是 J 是倒序，当 j 从小到大进行赋值时， dp[j] 可能会被重复使用
 *     // 假设 W = 8 w=1 时 当前第2轮循环中，dp[1] 是第二轮产物,而要进行的 dp[3]=dp[3],dp[1] 进行比较，此时 dp[3]是上一轮产物，dp[1]是这一轮产物
 *     // 使得后一轮循环元素影响了上一轮循环产物
 *     for j = W downTo w:
 *         dp[j] = dp[j],dp[j-w]
 * @author wezhyn
 * @since 07.31.2020
 *
 */
class PartitionEqualSubsetSum {

    fun best(nums: IntArray): Boolean {
        var sum = nums.sum()
        if (sum and 1 == 1) return false
        sum = sum.ushr(1)
        val dp = BooleanArray(sum + 1)
        dp[0] = true
        for (i in nums.indices) {
            for (j in sum downTo nums[i]) {
                dp[j] = dp[j] or dp[j - nums[i]]
            }
        }
        return dp[sum]
    }

    fun canPartition(nums: IntArray): Boolean {
        var totalSum = nums.sum()
        if (totalSum.rem(2) == 1) {
            return false
        }
        totalSum = totalSum.ushr(1)
        var result = TreeSet<Int>()
        var copyResult = TreeSet<Int>()
        result.add(0)
        for (r in nums) {
            for (v in result) {
                val e = v + r
                if (totalSum == e) {
                    return true
                } else if (e > totalSum) {
                    break
                } else {
                    copyResult.add(v)
                    copyResult.add(r)
                    copyResult.add(e)
                }
            }
            result = copyResult
            copyResult = TreeSet()
        }
        return false
    }

    /**
     * TLE
     */
    fun canPartitionWithSimpleDP(nums: IntArray): Boolean {
        val totalSum = nums.sum()
        if (totalSum.rem(2) == 1) {
            return false
        }
        val searchSum = totalSum.ushr(1)
        val dp = HashMap<Pair<Int, Int>, Boolean>()
        dp[Pair(-1, 0)] = true
        for (j in 0..searchSum) {
            for ((i, v) in nums.withIndex()) {
                dp[Pair(i, j)] = dp.getOrDefault(Pair(i - 1, j - v), false) ||
                        dp.getOrDefault(Pair(i - 1, j), false)
            }
        }
        return dp.getOrDefault(Pair(nums.size - 1, searchSum), false)

    }
}