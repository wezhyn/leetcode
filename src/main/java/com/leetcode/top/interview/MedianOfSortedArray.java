package com.leetcode.top.interview;

/**
 * 解法思路：https://www.youtube.com/watch?v=KB9IcSCDQ9k
 * n1(6): -1,1,3,5,7,9
 * n2(8): 2,4,6,8,10,12,14,16
 * 排序后: -1,1,2,3,4,5,6,7,8,9,10,12,14,16
 * 中位数为 6+7 /2= 6.5
 * 中位数：(n1+n2+1)/2 =7
 * 二分搜索的边界：[l, r),当 m1=r时，代表 取 n1中全部元素
 * 为何 使用 n1[m1] 与 n2[m2-1] 进行比较
 * 根据中位数定理可知，中位数k 所在的位置即 Max(n1[m1-1],n2[m2-1]) 中的最大者
 * 中位数后一位 k+1 所在为 Min(n1[m1],n2[m2]) ,所以n1[m1] 一定是大于 n2[m2-1]
 * 解法思路是通过取合理m1 的最小值，减少分支判断:
 * 当m1 =5时，m2=2, 这时 n1[m1]=9 , n2[m2-1]= 4 ,这时 符合上述规范, 但对比 排序后的数组，发现并不符合规范，
 * 且 n1[m1-1]=7,n2[m2]=6 ,n2[m2] < n1[m1-1] , 也是要不断减小m1 的取值，故而作者逻辑上取最小m1 ，简化了逻辑
 *
 * @author wezhyn
 * @since 03.12.2020
 */
public class MedianOfSortedArray {

    public static void main(String[] args) {
        int[] nums1=new int[]{1,3};
        int[] nums2=new int[]{2};
        System.out.println(new MedianOfSortedArray().findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        if (n1 > n2) {
            int[] tmp=nums2;
            nums2=nums1;
            nums1=tmp;
            n1=nums1.length;
            n2=nums2.length;
        }
        int k=(n1 + n2 + 1)/2;
        int l=0, r=n1;
        while (l < r) {
            int m1=l + (r - l)/2;
            int m2=k - m1;
            if (nums1[m1] < nums2[m2 - 1]) {
                l=m1 + 1;
            } else {
                r=m1;
            }
        }
        // m1 代表 nums 取了 m1 个 ，但 nums1[m1]是不在中位数左边
        int m1=l;
        int m2=k - l;
//        左边界问题：nums1 取0个，或取第一个
        int k1=Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
        if ((n1 + n2)%2==1) {
            return k1;
        }
        int k2=Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1],
                m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
        return (k1 + k2)*0.5;
    }
}
