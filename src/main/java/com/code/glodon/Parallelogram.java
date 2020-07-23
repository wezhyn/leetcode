package com.code.glodon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 给出你 n 条长度不一的边，请你从中选择四条边，组成一个最大的平行四边形。
 * <p>
 * <p>
 * 请你输出最大的平行四边形的面积
 * AC
 *
 * @author wezhyn
 * @since 07.22.2020
 */
public class Parallelogram {
    public static void main(String[] args) {
        HashMap<Long, Integer> edgeCounts = new HashMap<>();
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                final long nextCount = scanner.nextLong();
                edgeCounts.put(nextCount, edgeCounts.getOrDefault(nextCount, 0) + 1);
            }
        }
        PriorityQueue<Long> minQueue = new PriorityQueue<>();
        for (Map.Entry<Long, Integer> entry : edgeCounts.entrySet()) {
            if (entry.getValue() >= 2) {
                for (int time = 1; time <= entry.getValue() / 2; time++) {
                    if (minQueue.size() >= 2) {
                        minQueue.offer(entry.getKey());
                        minQueue.poll();
                    } else {
                        minQueue.offer(entry.getKey());
                    }
                }
            }
        }
        if (minQueue.size() >= 2) {
            System.out.println(maxArea(minQueue.poll(), minQueue.poll()));
        } else {
            System.out.println(-1);
        }
    }


    private static long maxArea(long a, long b) {
        if (a <= 0 || b <= 0) {
            return -1;
        }
        return a * b < 0 ? -1 : a * b;
    }
}
