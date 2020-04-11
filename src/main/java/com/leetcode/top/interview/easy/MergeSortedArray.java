package com.leetcode.top.interview.easy;

/**
 * @author wezhyn
 * @since 04.03.2020
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n==0) {
            return;
        }
        int gt=m + n - 1, mi=m - 1, ni=n - 1;
        while (mi >= 0 && ni >= 0) {
            int e=nums1[mi] - nums2[ni];
            if (e > 0) {
                nums1[gt--]=nums1[mi];
                mi--;
            } else {
                nums1[gt--]=nums2[ni];
                ni--;
            }
        }
        while (ni >= 0) {
            nums1[gt--]=nums2[ni--];
        }
    }

    private void swap(int[] num, int l, int r) {
        int old=num[l];
        num[l]=num[r];
        num[r]=old;
    }
}
