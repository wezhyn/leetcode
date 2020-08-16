package com.code.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * dp(1)=1
 * dp(2)=1 +dp(2/2) =2
 * dp(3)=1+dp(n/3) = 1+dp(1)=2
 * dp(4)= 1+ dp(3) | 1+ dp(2) = 3
 * dp(5) =1 +dp(4) = 4
 * dp(6) =1+dp(2) | 1+ dp(3) = 3
 * dp(7) = 1+ dp(6)
 * dp(8) = 1+ dp(4)
 * dp(9) = 1+dp(3) =3
 * dp(10) =1+dp(9) | 1+dp(5) = 4
 * <p>
 * <p>
 * 但 10^9 次方的数量级，dp[10^9] 超过内存，不可取
 * <p>
 * Leetcode 第一名做法：
 * dp(x) =Math.min(dp(i/2)+i%2+1,dp(i/3)+i%3+1)
 * 即取消了 对 n-1 的做法，使用 2 或者 3代替
 *
 * @author wezhyn
 * @since 08.16.2020
 */
public class EatOrange {
    Map<Integer, Integer> cache = new HashMap<>();

    public int minDays(int n) {
        if (n <= 2) {
            return n;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int result = Math.min(
                minDays(n / 2) + n % 2,
                minDays(n / 3) + n % 3
        ) + 1;
        cache.put(n, result);
        return result;
    }

}
