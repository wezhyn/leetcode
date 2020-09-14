package com.wezhyn.learn.array;

/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        doPartition(nums, 0, nums.length - 1);
        return nums[nums.length / 2];
    }


    private void doPartition(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int middle = nums.length / 2;
        int pIndex = partition(nums, l, r);
        if (pIndex < middle) {
            doPartition(nums, pIndex + 1, r);
        } else if (pIndex > middle) {
            doPartition(nums, l, pIndex - 1);
        }
    }

    private int partition(int[] nums, int l, int r) {
        if (l >= r) {
            return l;
        }
        int flag = nums[l];
        int li = l + 1, ri = r;
        while (li <= ri) {
            while (li <= ri && nums[li] < flag) li++;
            while (ri >= li && nums[ri] > flag) ri--;
            if (li > ri) {
                break;
            }
            swap(nums, li++, ri--);
        }
        swap(nums, l, li - 1);
        return li - 1;
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
