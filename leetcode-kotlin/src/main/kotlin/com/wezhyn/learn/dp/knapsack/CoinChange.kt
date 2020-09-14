package com.wezhyn.learn.dp.knapsack

/**
 *
You are given coins of different denominations and a total amount of money _amount_.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return `-1`.

 **Example 1:**

```
Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
```

 **Example 2:**

```
Input: coins = [2], amount = 3
Output: -1
```
 * dp[i][j] coins[0:i] 中货币到达 j 的最少数量
 *
 * dp[i][j] = Math.min(dp[i-1][j],dp[i][j-w])
 *
 * dp[j]=Math.min(dp[j],dp[j-w]
 * @author wezhyn
 * @since 07.31.2020
 *
 */
class CoinChange {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0
        for (c in coins) {
            for (j in c..amount) {
                dp[j] = Math.min(dp[j], dp[j - c] + 1)
            }
        }

        return if (dp[amount] == amount + 1) -1 else dp[amount]
    }

}