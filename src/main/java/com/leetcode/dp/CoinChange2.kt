package com.leetcode.dp

/**
 *

You are given coins of different denominations and a total amount of money.
Write a function to compute the number of combinations that make up that amount.
You may assume that you have infinite number of each kind of coin.

 **Example 1:**

```
Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
```

 **Example 2:**

```
Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
```

 * 即完全背包问题： unBounded knapsack problem
 * dp[i][j] 表示前i件物品等于 j 的次数
 *
 * dp[i][j]=dp[i-1][j-w] + dp[i-1][j]
 *
 * dp[j]=dp[j]+dp[j-w]
 *
 * @author wezhyn
 * @since 07.31.2020
 *
 */
class CoinChange2 {
    fun change(amount: Int, coins: IntArray): Int {
        val dp = IntArray(amount + 1)
        dp[0] = 1
        for (c in coins) {
            for (j in c..amount) {
                dp[j] += dp[j - c]
            }
        }
        return dp[amount]
    }
}