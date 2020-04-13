package com.leetcode.algorithm;

/**
 * DP1: 输入是 O(n), 空间 O(n) -> O(1)
 * dp(x) 依赖于有限个最优子结构
 * <p>
 * 爬楼梯问题：
 * 记 f(x) 为爬至 x th 层楼梯时的走法
 * 特别：f(1) =1 ,f(2) =2
 * 爬至第 Xth 层时 ，可以先爬到 (X-1)th 或者 (X-2)th
 * 并非 (X-1)th +1 或者 (X-2)th +1, 对于 f(x), +1 即是(X-1)th 或者(X-2)th
 * 状态转移方程：
 * f(x)=f(x-1)+f(x-2)
 *
 * @author wezhyn
 * @since 03.15.2020
 */
public class ClimbingStairs {


    public static void main(String[] args) {
        ClimbingStairs climbingStairs=new ClimbingStairs();
        System.out.println(climbingStairs.climbStairsPro(3));
        System.out.println(climbingStairs.climbStairsPro(4));
    }

    public int climbStairsPro(int n) {
//        注意临界值
        if (n <= 1) {
            return 1;
        }
        int dp1=1;
        int dp2=2;
        for (int i=3; i <= n; i++) {
            int current=dp1 + dp2;
            dp1=dp2;
            dp2=current;
        }
        return dp2;
    }

    public int climbStairs(int n) {
//        注意临界值
        if (n <= 1) {
            return 1;
        }
        // 从 1 开始计算
        int[] dp=new int[n + 1];
        dp[1]=1;
        dp[2]=2;
        for (int i=3; i <= n; i++) {
            dp[i]=dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
