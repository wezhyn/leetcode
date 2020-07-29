package com.random

/**

Given a **non-negative** integer n, count all numbers with unique digits, x, where 0 ≤ x < 10<sup>n</sup>.


 **Example:**

```
Input: 2
Output: 91
Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
             excluding 11,22,33,44,55,66,77,88,99
```

 * @author wezhyn
 * @since 07.25.2020
 *
 */
class CountNumbersWithUniqueDigits {
    fun countNumbersWithUniqueDigits(n: Int): Int {
        val dp = IntArray(10) { 1 }
        for (i in 1..n) {
            dp[i] = permutation(i) + dp[i - 1]
        }
        return dp[n]
    }

    private fun permutation(n: Int): Int {
        var nn = n
        var result = 9
        var remain = 9
        while (nn > 1) {
            result *= remain--
            nn--
        }
        return result
    }
}