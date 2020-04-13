package com.leetcode.algorithm;

/**
 * DP1: 输入是 O(n)
 * dp(x) 依赖于有限个最优解
 * <p>
 * 偷钱问题：一个一维数组代表一个连续房屋，数组对应的元素代表该房屋所能偷窃到的金额
 * 限制：不能连续偷取两个相连的元素， 即 i-1,i,i+1 中的前两者，或后两者
 * 要求：可偷窃的最大金额数
 * <p>
 * 记 f(x) 为 偷取到某家为止，偷取到的最大金额数
 * 特例(Note: 数组从0开始)：
 * f(1)即 arr[0]
 * f(2) 即 max(arr[1],arr[0])
 * 偷取第3家后，只能偷第1家|偷f(2)
 * f(3) 即 max(arr[2]+f(1),f(1))
 * 偷取第4家后，只能投1，2家中最大的||偷f(3)
 * f(4) 即 max(arr[3]+f(2),f(3))
 * <p>
 * f(x) =max(arr[x-1]+f(x-2),f(x-1)
 *
 * @author wezhyn
 * @since 03.15.2020
 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] houses=new int[]{};
        System.out.println(new HouseRobber().rob(houses));
    }

    public int rob(int[] nums) {
//        边界问题:必须大于1
        if (nums.length==1) {
            return nums[0];
        } else if (nums.length < 1) {
            return 0;
        }
        // 从1开始，将2规范化，即 f(x)=max(arr[x]+f(x-2),f(x-1)
        int[] dp=new int[nums.length + 1];
        dp[0]=0;
        dp[1]=nums[0];
        for (int i=1; i < nums.length; i++) {
            dp[i + 1]=Math.max(nums[i] + dp[i - 1], dp[i]);
        }
        return dp[nums.length];
    }
}
