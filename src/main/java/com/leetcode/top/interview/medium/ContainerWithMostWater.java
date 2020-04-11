package com.leetcode.top.interview.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * 双指针：
 * 总容量=min(hl,hr)*(len)
 * 指针从两边向中间移动时，len 变小，为了使总容量变大，min(hl,hr)必须变大，内移最短板的指针，直至重合
 *
 * @author wezhyn
 * @since 04.05.2020
 */
public class ContainerWithMostWater {


    @Test
    public void test() {
        Assert.assertEquals(49, maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
    public int maxArea(int[] height) {
        int hl=0, hr=height.length - 1;
        int max=0;
        while (hl < hr) {
            int lh=height[hl];
            int rh=height[hr];
            int cur=(hr - hl)*(Math.min(lh, rh));
            if (cur > max) {
                max=cur;
            }
            if (lh < rh) {
                hl++;
            } else {
                hr--;
            }
        }
        return max;
    }
}
