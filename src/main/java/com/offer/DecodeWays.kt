package com.offer

/**
 *
 * 'A' -> 1
 * 'B' -> 2
 * 'Z' -> 26
 *
 * 假设字符串 2612
 * 2  -> B
 * 26 -> BF| Z
 * 261 -> BFZ|ZA 即 (BF|Z)(A)+ B(61) 无效
 * 2612 -> BFZB|ZAB|BFL|ZL 即 (BFZ|ZA)(B) + (BF|Z)(L)
 * dp[i]=dp[i-1](arr[i])+dp[i-2](arr[i-1,i])
 * dp(2)=dp(1)*1+dp(0)*[26] =2
 * dp(3)=dp(2)*1+dp(1)*[62]=2
 * dp(4)=dp(3)*[2]+dp(2)*[12]=2+2
 * @author wezhyn
 * @since 07.12.2020
 *
 */
class DecodeWays {


    fun numDecodings(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }
        var dpPre = if (s[0] == '0') 0 else 1
        var dpPrePre = 1
        val sArray = s.toCharArray()
        for (i in 1 until s.length) {
            var result = 0
            val singleNum = calculate(sArray, i, i)
            val doubleNum = calculate(sArray, i - 1, i)
            result += if (singleNum == 0) 0 else dpPre
            result += if (doubleNum <= 0 || doubleNum > 26) 0 else dpPrePre
            if (result == 0) {
                return 0
            }
            dpPrePre = dpPre
            dpPre = result
        }
        return dpPre
    }


    /**
     * 0x 返回0
     */
    private fun calculate(array: CharArray, l: Int, r: Int): Int {
        require(r - l <= 1)
        require(r < array.size)
        var result = array[l] - '0'
        if (result == 0 || l == r) {
            return result
        }
        result = result * 10 + (array[r] - '0')

        return result
    }
}