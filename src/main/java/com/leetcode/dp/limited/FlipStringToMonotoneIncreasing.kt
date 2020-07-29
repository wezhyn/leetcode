package com.leetcode.dp.limited

/**

A string of `'0'`s and `'1'`s is _monotone increasing_ if it consists of some number of `'0'`s (possibly 0), followed by some number of `'1'`s (also possibly 0.)

We are given a string `S` of `'0'`s and `'1'`s, and we may flip any `'0'` to a `'1'` or a `'1'` to a `'0'`.

Return the minimum number of flips to make `S` monotone increasing.

 **Example 2:**

```
Input: "010110"
Output: 2
Explanation: We flip to get 011111, or alternatively 000111.
```


 **Example 3:**

```
Input: "00011000"
Output: 2
Explanation: We flip to get 00000000.
```
 * 题意： 将字符串进行变化，将字符串划分成两半，左边为0，右边为1 ，允许全0和全1的存在
 * 使用 f(i)[0] 表示翻转第i个元素为0时，从1-i满足要求的最小次数 ,f(i)[1]同理
 * 从右向左
 * f(i)[0]= arr[i]+ Min(f(i-1)[0],f(i-1)[1])
 * f(i)[1]= (arr[i]-1) + f(i-1)[1]
 * @author wezhyn
 * @since 07.24.2020
 *
 */
class FlipStringToMonotoneIncreasing {
    fun minFlipsMonoIncr(S: String): Int {
        val result = Array(S.length) { IntArray(2) }
        val array = S.toCharArray().reversedArray()
        var lastOne = 0
        for ((i, v) in array.withIndex()) {
            if (i == 0) {
                result[i][0] = v - '0'
                result[i][1] = '1' - v
            } else {
                if (v == '1') {
                    lastOne = i
                }
                result[i][0] = (v - '0') + Math.min(result[i - 1][0], result[i - 1][1])
                result[i][1] = ('1' - v) + result[i - 1][1]
            }
        }

        return Math.min(result[lastOne][0], result[lastOne][1])
    }
}