package com.code.cts;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 给定一个序列，按照给定的顺序进行输出：
 * 9
 * 25 84 21 47 15 27 68 35 20
 * <p>
 * output:
 * 15 20 21 25 47 27 68 35 84
 * 15 20 21 25 47 27 68 35 84
 * 15 20 21 25 47 27 68 35 84
 * 15 20 21 25 35 27 47 68 84
 * 15 20 21 25 27 35 47 68 84
 * 15 20 21 25 27 35 47 68 84
 * <p>
 * 猜测规律：
 * 1. 找到比当前元素小的所有元素，即25 和最大的元素 84【未排序过的最大值】
 * 21，15，20  -> 15 20 21
 * 2. 下一个元素 20 无最小
 * 3. 下一个元素 21 无最小
 * 下一个元素25 已经搜索过
 * 4. 下一个元素 47
 * 小于：27,35 -> 35,27 最大68
 * 5. 下一个元素35
 * 小于：27 -> 27 最大47
 * 6. 最后输出排序后的数组
 * <p>
 * 还有一个规律：
 * 21，15，20 -> 15 20 21
 * 27,35     -> 35,27
 * 27        -> 27
 * 第一个21 前21之前附加 15，21前加
 * <p>
 * 未写完 。。。竟然是快排
 *
 * @author wezhyn
 * @since 07.31.2020
 */
public class SequenceSort {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int[] sequences = new int[in.nextInt()];
            for (int i = 0; i < sequences.length; i++) {
                sequences[i] = in.nextInt();
            }
            int l = 0;
            int r = sequences.length - 1;
            Set<Integer> hasVisited = new HashSet<>();
            int curMin = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
            while (l <= r) {
                if (sequences[l] > curMin) {
                    List<Integer> minSequences = minSequences(sequences, l, r);
                    swap(minSequences, sequences, l);
                } else {
                    l++;
                }
                printArrays(sequences);
            }
        }
    }


    private static void swap(List<Integer> minSequences, int[] sequences, int l) {
        int[] copy = Arrays.copyOfRange(sequences, l, sequences.length);
        modifyMinSequences(minSequences);
        int li = l;
        for (int m : minSequences) {
            sequences[li++] = m;
        }
        for (int i = l; i < copy.length; i++) {
            if (minSequences.contains(copy[i])) {
                minSequences.remove(copy[i]);
            } else {
                sequences[li++] = copy[i];
            }
        }
    }

    //                  21，15，20 -> 15 20 21
//                27,35     -> 35,27
//                27        -> 27
    private static void modifyMinSequences(List<Integer> sequences) {
        final Integer remove = sequences.remove(0);
        sequences.add(remove);
    }

    private static List<Integer> minSequences(int[] sequences, int l, int r) {
        List<Integer> minSequences = new ArrayList<>();
        for (int i = l + 1; i <= r; i++) {
            if (sequences[i] < sequences[l]) {
                minSequences.add(sequences[i]);
            }
        }
        return minSequences;
    }

    private static void printArrays(int[] arrays) {
        final String str = IntStream.of(arrays)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(str);
    }


}
