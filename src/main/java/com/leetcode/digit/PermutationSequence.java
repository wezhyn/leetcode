package com.leetcode.digit;

import java.util.LinkedList;

/**
 * @author wezhyn
 * @since 09.05.2020
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        final StringBuilder sb = new StringBuilder();
        while (k > 0) {
//            n 个元素最多有 n! 个排列，对于第一个元素而言 都有 (N-1)! 排序
            final int permutation = permutation(numbers.size() - 1);
            int nTh = k / permutation;
            final Integer ceiling = numbers.get(k % permutation == 0 ? nTh - 1 : nTh);
            sb.append(ceiling);
            numbers.remove(ceiling);
            k = k - nTh * permutation;
//            为当前剩余元素的倒序
            if (k == 0) {
                while (!numbers.isEmpty()) {
                    sb.append(numbers.pollLast());
                }
            }
        }
        return sb.toString();
    }


    private int permutation(int n) {
        int result = 1;
        while (n > 1) {
            result *= n;
            n--;
        }
        return result;
    }
}
