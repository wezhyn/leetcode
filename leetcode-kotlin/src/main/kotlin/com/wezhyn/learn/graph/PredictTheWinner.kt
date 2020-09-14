package com.wezhyn.learn.graph

/**
 *
 * Min-Max Strategy 类型题目: Always pick the best
 *
 * 使用一个二维数组保存 (l,r) 对应的数据差 进行计划递归
 * dp(l,l) = 只有一个元素时的差
 * dp(l,r) = 多余一个元素时，能获取的最大差值
 * 模拟 栈的回归，先从 len =1，到2 到3 .. n-1
 *
 **Example 1:**

```
Input: [1, 5, 2]
Output: False
Explanation: Initially, player 1 can choose between 1 and 2.
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5.
If player 2 chooses 5, then player 1 will be left with 1 (or 2). S
o, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
Hence, player 1 will never be the winner and you need to return False.
```

 **Example 2:**

```
Input: [1, 5, 233, 7]
Output: True
Explanation: Player 1 first chooses 1.
Then player 2 have to choose between 5 and 7.
No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
```

 **Note:**

1.  1 <= length of the array <= 20.
2.  Any scores in the given array are non-negative integers and will not exceed 10,000,000.
3.  If the scores of both players are equal, then player 1 is still the winner.

```
 * @author wezhyn
 * @since 06.16.2020
 *
 */


class PredictTheWinner {
    private lateinit var dp: Array<IntArray>

    fun dpPredictTheWinner(nums: IntArray): Boolean {
        dp = Array(nums.size) { IntArray(nums.size) { 0 } }
        for (i in nums.indices) {
            dp[i][i] = nums[i]
        }
//        从 2 开始进行递归回退
        for (len in 2 until nums.size) {
            for (i in 0 until nums.size - len) {
//                差值为2 ，数量 -1 ， 0，1，2
                val j = i + len - 1
                dp[i][j] = Math.max(
                        nums[i] - dp[i + 1][j],
                        nums[j] - dp[i][j - 1]
                )
            }
        }
        return dp[0][nums.size - 1] > 0
    }

    fun PredictTheWinner(nums: IntArray): Boolean {
        dp = Array(nums.size) { IntArray(nums.size) { 0 } }
        return selectDiff(nums, 0, nums.size - 1) >= 0
    }

    private fun selectDiff(nums: IntArray, l: Int, r: Int): Int {
        if (l == r) {
            return nums[l]
        }
        val result = Math.max(
                nums[l] - selectDiff(nums, l + 1, r),
                nums[r] - selectDiff(nums, l, r - 1))
        this.dp[l][r] = result
        return result
    }
}