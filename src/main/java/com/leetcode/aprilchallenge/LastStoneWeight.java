package com.leetcode.aprilchallenge;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wezhyn
 * @since 04.12.2020
 */
public class LastStoneWeight {

    @Test
    public void test() {
        Assert.assertEquals(1, lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap=new PriorityQueue<>((i1, i2)->i2 - i1);
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() >= 2) {
            int x=maxHeap.poll();
            int y=maxHeap.poll();
            int m=x - y;
            if (m > 0) {
                maxHeap.offer(m);
            }
        }
        if (maxHeap.size()==1) {
            return maxHeap.poll();
        } else {
            return 0;
        }
    }
}
