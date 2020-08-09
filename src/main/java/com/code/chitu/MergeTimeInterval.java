package com.code.chitu;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定⼀个按开始时间从⼩到⼤排序的时间区间集合，请将重叠的区间合并。
 * 时间区间集合⽤⼀个⼆维数组表示，⼆维数组的每⼀⾏表示⼀个时间区间（闭区间），
 * 其中 0 位置元素表示时间区间开始，1 位置元素表示时间区间结束。
 *
 * @author wezhyn
 * @since 08.07.2020
 */
public class MergeTimeInterval {

    private static final int MAX_TIME = 24;

    /**
     * 使用一个一维数组保存[0-24]保存时间区间是否存在，最后在从一维数组中获取连续的时间段
     *
     * @param intervals 时间跨度
     * @return 融合后的时间
     */
    public int[][] merge(int[][] intervals) {
        boolean[] times = new boolean[MAX_TIME];
//        将当前时间段解析到 times中
        for (int[] interval : intervals) {
//            [1,3]
            int start = interval[0];
            int end = interval[1];
            if (start > end || end >= MAX_TIME) {
                throw new IllegalArgumentException();
            }
            for (int i = start; i <= end; i++) {
                times[i] = true;
            }
        }
//        从times中提取时间段
        List<int[]> results = new ArrayList<>();
        boolean start = false;
        int s = 0;
        for (int i = 0; i < MAX_TIME; i++) {
            if ((!start && times[i])) {
                start = true;
                s = i;
            } else if (start && !times[i]) {
                start = false;
                results.add(new int[]{s, i - 1});
            }
        }
        return results.toArray(new int[][]{});
    }

}
