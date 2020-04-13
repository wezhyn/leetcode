package com.leetcode.algorithm;

/**
 * DP1: 输入是O(n)
 * dp(x) 依赖于有限个最优解
 * <p>
 * 用最少的钱爬完楼梯：一个一维数组中的每个元素，代表对应的层数走过需要花费多少钱
 * 限制：付完一层阶梯的钱后，能向上走 1 至 2 级楼梯
 * 要求：使用最少的钱
 * <p>
 * 记 f(x) 为爬取到某层时，花费的最少钱
 * 特例[一维数组从0开始计数]：
 * f(0) = 0
 * f(1) = arr[0]
 * f(2) = arr[1]
 * f(3) = min(f(2),f(1))+arr[2]
 * f(4) = min(f(3),f(2))+arr[3]
 * <p>
 * 即 f(x)= min(f(x-1),f(x-2))+arr[x-1] x>2
 *
 * @author wezhyn
 * @since 03.15.2020
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] stairs=new int[]{1, 100};
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(stairs));
    }

    public int minCostClimbingStairs(int[] cost) {
        int dp1=cost[0];
        int dp2=cost[1];
        for (int x=3; x <= cost.length; x++) {
//           f(x)= min(f(x-1),f(x-2)) x>2
            int currentDp=Math.min(dp1, dp2) + cost[x - 1];
            dp1=dp2;
            dp2=currentDp;
        }
        return Math.min(dp1, dp2);
    }
}
