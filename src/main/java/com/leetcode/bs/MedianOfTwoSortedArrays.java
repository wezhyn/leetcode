package com.leetcode.bs;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1` 和 `nums2`。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 `nums1` 和 `nums2` 不会同时为空。
 * <p>
 * **示例 1:**
 * <p>
 * ```
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * ```
 * <p>
 * **示例 2:**
 * <p>
 * ```
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * ```
 * <p>
 * 中位数的特点相当于在每个数组上划分了两个区间，Arr -> {a1,a2} Brr -> {b1,b2}
 * 1. 对于Arr+Brr 长度奇偶性的情况，可以划分如下：
 * 偶数：a1+b1 == a2+b2
 * 奇数：a1+b1 == a2+b2 +1 || a1+b1+1 == a2+b2
 * > 此以 a1+b1 == a2+b2+1 为例
 * <p>
 * 2. 中位数是一个排序后的数组中的中位数,中位数左边的全部元素小于等于右边的全部元素
 * 则 Max{a1,b1} <= Min{a2,b2}
 * <p>
 * 3. 由于数组长度已知，所以 k 为 Arr 的中位数索引，则 Brr 的中位数索引也可得知
 * 偶数：(arr.len+brr.len)/2 - k
 * 奇数：(arr.len+brr.len+1)/2 -k
 * 由于 (偶数+1)/2 == (偶数)/2 所以 Brr 的索引为 (arr.len+brr.len+1)/2 -k
 *
 * @author wezhyn
 * @since 08.27.2020
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
//        al ,ar nums1 中的位置， kb 为 nums2 中的位置 ka = k+1
        int al = 0, ar = nums1.length;
        while (al <= ar) {
//            数组从0开始，所以ka = k +1 为分界线的右端 ，则 kb = (totalLen+1)/2 -k +1 所以
//            ka 和 kb 均不包含在a1,b1中 由于ka不包含，则最大ka = [0,len]
            int ka = al + (ar - al) / 2;
            int kb = (nums1.length + nums2.length + 1) / 2 - ka;
            int kal = ka == 0 ? Integer.MIN_VALUE : nums1[ka - 1], kar = ka == nums1.length ? Integer.MAX_VALUE : nums1[ka];
            int kbl = kb == 0 ? Integer.MIN_VALUE : nums2[kb - 1], kbr = kb == nums2.length ? Integer.MAX_VALUE : nums2[kb];
            final int kl = Math.max(kal, kbl);
            final int kr = Math.min(kar, kbr);
            if (kl > kr) {
//                ka 位置过大
                if (kal >= kbl) {
                    ar = ka - 1;
                } else {
                    al = ka + 1;
                }
            } else {
                return (nums1.length + nums2.length) % 2 == 1 ? kl : (kl + kr) / 2.0;
            }
        }
        return 0;
    }
}
