package com.wezhyn.learn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparing(ints -> ints[0]));
        List<int[]> merges = new ArrayList<>();
        merges.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = merges.get(merges.size() - 1);
            int[] cur = intervals[i];
            if (cur[0] <= last[1]) {
//                合并
                last[1] = Math.max(last[1], cur[1]);
            } else {
//                无法合并
                merges.add(cur);
            }
        }
        return merges.toArray(new int[0][0]);
    }

}
