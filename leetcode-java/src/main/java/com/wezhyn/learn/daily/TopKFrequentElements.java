package com.wezhyn.learn.daily;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author wezhyn
 * @since 09.07.2020
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, int[]> numsAggregation = new HashMap<>();
        for (int n : nums) {
            final int[] ints = numsAggregation.computeIfAbsent(n, kk -> new int[]{0});
            ints[0]++;
        }
        PriorityQueue<Map.Entry<Integer, int[]>> queue = new PriorityQueue<>(Comparator.comparingInt(kk -> kk.getValue()[0]));
        for (Map.Entry<Integer, int[]> entry : numsAggregation.entrySet()) {
            queue.add(entry);
            while (queue.size() > k) {
                queue.poll();
            }
        }
        int[] results = new int[queue.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = queue.poll().getKey();
        }
        return results;
    }
}
