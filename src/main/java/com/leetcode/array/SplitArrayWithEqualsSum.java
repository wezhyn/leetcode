package com.leetcode.array;

import java.util.*;

/**
 * 给定一个有 n 个整数的数组，你需要找到满足以下条件的三元组 (i, j, k) ：
 * <p>
 * 0 < i, i + 1 < j, j + 1 < k < n - 1
 * 子数组 (0, i - 1)，(i + 1, j - 1)，(j + 1, k - 1)，(k + 1, n - 1) 的和应该相等。
 * 这里我们定义子数组 (L, R) 表示原数组从索引为L的元素开始至索引为R的元素。
 * <p>
 * 输入: [1,2,1,2,1,2,1]
 * 输出: True
 * 解释:
 * i = 1, j = 3, k = 5.
 * sum(0, i - 1) = sum(0, 0) = 1
 * sum(i + 1, j - 1) = sum(2, 2) = 1
 * sum(j + 1, k - 1) = sum(4, 4) = 1
 * sum(k + 1, n - 1) = sum(6, 6) = 1
 * <p>
 * 将一个数组使用三个索引进行划分，使得数组被划分成4个相等区间，不包含 i,j,k
 * K<n-1
 * [0,i-1] -> i>=1
 * I[i+1,j-1]J -> j>=i+2
 * J[j+1,k-1]K -> k>=j+2
 * K[k+1,n-1] -> k<=n-2
 * i<=j -2
 * j <= k-2 -> i<= k-4
 * k<=n-2 -> i<=n-6
 * <p>
 * -> 1<=i<=n-6 ; i+2 <=j <= n-4 ; j+2 <=k <= n-2
 * <p>
 * <p>
 * 当使用暴力法解法时，即遍历 i,j,k所有可能出现结果，会超时【累加暴力解法】
 * <p>
 * 即 O(n^3) 次方无法解决，只有 O(n^2) 才能Accept ，将给定条件进行整理：
 * 1. 使用 sum(i) 表示 0..i 的累加和
 * 2. [0,i-1] , [i+1,j-1] ,[j+1,k-1] ,[k+1,n-1] 相等
 * 即 sum(i-1) = sum(j-1) - sum(i-1) -nums[i] = sum(k-1) - sum(j-1) -num[j] = sum(n-1) - sum(k-1) -num(k)
 * sum(j-1) = 2sum(i-1) + nums[i]
 * sum(k-1) = 3sum(i-1) + num[i] +nums[j]
 * sum(n-1) = 4sum(i-1) +num[i] +nums[j] +nums[k]
 * 即将4个数组划分成了与第一个数组 sum(i-1) 相关的数据 ， 以 j 为划分中心，找到满足第一个条件的i，推出相应 K 位置
 * <p>
 * 但如果给定的 k 位置数量太多 也会蜕变成 O(n^3) ,超时
 * <p>
 * Set 方法
 * 1. 划分j 点
 * 2. 划分 i 点，找到能够使 a1=a2 的i点，并使 sum 加入到 set 中，这样，set中保存了 前两个数组相等的所有可能
 * 3. 划分 k 点，找到 使得 a3=a4 的k点，并判断 set 中是否有该值，如果有，则存在
 *
 * @author wezhyn
 * @since 08.28.2020
 */
public class SplitArrayWithEqualsSum {
    public boolean splitArray(int[] nums) {
        if (nums.length < 7) {
            return false;
        }
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sums[i] = nums[i] + (i == 0 ? 0 : sums[i - 1]);
        }


        for (int j = 3; j <= nums.length - 4; j++) {
            Set<Integer> sumSet = new HashSet<>();
            for (int i = 1; i < j; i++) {
                if (sums[i - 1] == sums[j - 1] - sums[i]) {
                    sumSet.add(sums[i - 1]);
                }
            }
            for (int k = j + 2; k <= nums.length - 2; k++) {
                if (sums[nums.length - 1] - sums[k] == sums[k - 1] - sums[j] && sumSet.contains(sums[k - 1] - sums[j])) {
                    return true;
                }

            }
        }
        return false;
    }

    public boolean splitArrayHash(int[] nums) {
        if (nums.length < 7) {
            return false;
        }
        int[] sums = new int[nums.length];
        HashMap<Integer, List<Integer>> sumsIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sums[i] = nums[i] + (i == 0 ? 0 : sums[i - 1]);
            List<Integer> indexs = sumsIndex.computeIfAbsent(sums[i], k -> new ArrayList<>());
            indexs.add(i);
        }


        for (int j = 3; j <= nums.length - 4; j++) {
            for (int i = 1; i < j; i++) {
                if (2 * sums[i - 1] + nums[i] == sums[j - 1]) {
                    int targetKSum = 3 * sums[i - 1] + nums[i] + nums[j];
//                    k-1 index
                    final List<Integer> kIndexs = sumsIndex.get(targetKSum);
                    if (kIndexs == null) {
                        continue;
                    }
                    for (int k : kIndexs) {
                        k += 1;
                        if (k < j + 2 || k >= nums.length - 1) {
                            continue;
                        }
//                        符合条件的k
                        int targetNSum = 4 * sums[i - 1] + nums[i] + nums[j] + nums[k];
                        final List<Integer> nIndex = sumsIndex.get(targetNSum);
                        if (nIndex != null && nIndex.contains(nums.length - 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
