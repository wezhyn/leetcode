package com.code.didi;

/**
 * 在组合数学中，如果一个排列中所有元素都不在原先的位置上，那么这个排列就被称为错位排列。
 * <p>
 * 给定一个从1 到 n升序排列的数组，你可以计算出总共有多少个不同的错位排列吗？
 * <p>
 * 由于答案可能非常大，你只需要将答案对 109+7 取余输出即可。
 * <p>
 * <p>
 * Input: 3
 * Output: 2
 * Explanation: [2,3,1][3,1,2]
 * <p>
 * 即错排问题，使用 f(n) 表示 n 个元素的错排结果，考虑如下情况，将 x 元素放置在 k 位置(x!=k):
 * 1. k 放置在 x 元素上，则 该结果为 f(n-2) 的错排结果
 * 2. k 不放置在 x 元素上，相当于 f(n-1) 【错排的意思就是 目标元素 k 不放置在 k 位置，这里进行了扩展】
 * <p>
 * 则 f(n) 会跟 f(n-1) f(n-2) 有关，在某一次排序中，x 元素的可以放置在除了x的位置，即 1,2,3..x-1,x+1..n-1,n
 * 所以一共有 N-1 种可能性，所以 f(n) = (n-1)(f(n-1)+f(n-2))
 *
 * @author wezhyn
 * @since 08.28.2020
 */
public class FindTheDerangementOfArray {

    private static final int MOD = 1000000007;

    public int findDerangement(int n) {
        if (n == 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            long r = (i - 1) * (dp[i - 1] + dp[i - 2]);
            dp[i] = (int) (r % MOD);
        }
        return dp[n];
    }
}
