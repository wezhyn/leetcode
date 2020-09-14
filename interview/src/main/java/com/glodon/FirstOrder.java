package com.glodon;

import java.util.*;

/**
 * 有一种排序算法定义如下，该排序算法每次只能把一个元素提到序列的开头，例如 2，1，3，4，只需要一次操作把 1 提到序列起始位置就可以使得原序列从小到大有序。
 * <p>
 * 现在给你个乱序的 1-n 的排列，请你计算最少需要多少次操作才可以使得原序列从小到大有序
 * AC
 *
 * @author wezhyn
 * @since 07.22.2020
 */
public class FirstOrder {

    public static void main(String[] args) {
//        对应某个整数在队列中的位置
        Map<Integer, List<Integer>> cache = new HashMap<>();
        int[] nums;
        int result = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                int next = scanner.nextInt();
                final List<Integer> list = cache.getOrDefault(next, new ArrayList<>());
                list.add(i);
                cache.put(next, list);
                nums[i] = next;
            }
            Arrays.sort(nums);
//            计算次数
            for (int i = nums.length - 2; i >= 0; i--) {
                int cur = nums[i];
                int pre = nums[i + 1];
                if (cur == pre) {
                    continue;
                }
                List<Integer> curOffset = cache.get(cur);
                List<Integer> preOffset = cache.get(pre);
                result += orderNum(curOffset, preOffset);
            }
        }
        System.out.println(result);
    }

    private static int orderNum(List<Integer> curOffset, List<Integer> preOffset) {
        int preMinOffset = Integer.MAX_VALUE;
        for (Integer i : preOffset) {
            preMinOffset = Math.min(i, preMinOffset);
        }
        int result = 0;
        for (Integer i : curOffset) {
            if (i >= preMinOffset) {
                result++;
            }
        }
        preOffset.clear();
        preOffset.add(preMinOffset);
        if (result > 0) {
            curOffset.clear();
            curOffset.add(0);
            final Integer i = preOffset.get(0);
            preOffset.add(i + 1);
        }
        return result;
    }
}
