package com.leetcode.dp

/**
Given two strings `s1, s2`, find the lowest ASCII sum of deleted characters to make two strings equal.

 **Example 1:**

```
Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
```

 **Example 2:**

```
Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
```
 * dp[i][j] 代表 s1[0..i] 到 s2[0..j] equals 最小 delete 值
 * @see EditDistance
 * @author wezhyn
 * @since 07.28.2020
 *
 */
class MinimumASCIIDeleteSumForTwoStrings {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val dp = initDp(s1, s2)
        for (i in 1..s1.length) {
            for (j in 1..s2.length) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j - 1] + s1[i - 1].toInt() + s2[j - 1].toInt(),
                            Math.min(dp[i][j - 1] + s2[j - 1].toInt(), dp[i - 1][j] + s1[i - 1].toInt())
                    )
                }
            }
        }
        return dp[s1.length][s2.length]
    }


    private fun initDp(s1: String, s2: String): Array<IntArray> {
        val dp = Array(s1.length + 1) { IntArray(s2.length + 1) }

        for (i in 1..s1.length) {
            dp[i][0] = s1[i - 1].toInt() + dp[i - 1][0]
        }
        for (i in 1..s2.length) {
            dp[0][i] = s2[i - 1].toInt() + dp[0][i - 1]
        }
        return dp
    }
}