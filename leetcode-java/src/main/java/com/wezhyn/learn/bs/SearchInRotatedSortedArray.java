package com.wezhyn.learn.bs;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别
 * <p>
 * 由于不存在重复元素，可以直接使用二分搜索来做
 *
 * @author wezhyn
 * @since 08.28.2020
 */
public class SearchInRotatedSortedArray {


    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int mNum = nums[m];
            if (mNum == target) {
                return m;
            }
//            现根据 mNum 划分出一个递增区间
            if (mNum >= nums[0]) {
//                [l,m] 是有序递增
//                当前 M 位于第一数组中，但小于当前元素还可能发生在第二递增数组
                if (target > mNum || target < nums[0]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
//                [m,r] 有序递增 M 在第二个递增数组中，则大于M 的还可能在第一数组中
                if (target < mNum || target >= nums[0]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

        }
        return -1;
    }
}
