package com.leetcode.algorithm.wait;

/**
 * DP1 输入是 O(n)
 * dp(x) 依赖于有限个解
 * <p>
 * 两种牌覆盖问题：现有两种类型的牌，每一种类型都可以进行旋转如下：
 * XX  ==> X    XX  ==> XX  ==> X    ==>  X
 * X    X        X      XX       XX
 * 限制：铺满，即在 2* N 的区域内，全覆盖，即 2*N 的区域内全是 X
 * 要求: 给出有多少种可能性
 * <p>
 * 解法：https://www.youtube.com/watch?v=S-fUTfqrdq8
 *
 * @author wezhyn
 * @since 03.15.2020
 */
public class DominoAndTrominoTiling {

    public int numTilings(int n) {
        int[][] dp=new int[n][2];
//         f(x)=dp[i-1][0]+dp[i-2][0] + dp[i-1][1]+ dp[i-1][2]
//        dp[i-1][1]=dp[i-2][0]+dp[i-1][2]
        return 0;
/*        dp[0][0]=dp[1][0]=1;
        for (int i=2; i <=n; i++) {
            dp[i][0]=

        }*/
    }

}
