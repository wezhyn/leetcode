package com.wezhyn.learn.array;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 i ai),在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 * <p>
 * 双指针：
 * 总容量=min(hl,hr)*(len)
 * 指针从两边向中间移动时，len 变小，为了使总容量变大，min(hl,hr)必须变大，内移最短板的指针，直至重合
 *
 * @author wezhyn
 * @since 08.28.2020
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int hl = 0, hr = height.length - 1;
        int max = 0;
        while (hl < hr) {
            int lh = height[hl], rh = height[hr];
            int cur = (hr - hl) * (Math.min(lh, rh));
            max = Math.max(cur, max);
            if (lh < rh) {
                hl++;
            } else {
                hr--;
            }
        }
        return max;
    }
}
