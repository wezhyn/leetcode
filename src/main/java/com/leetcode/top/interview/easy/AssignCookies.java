package com.leetcode.top.interview.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wezhyn
 * @since 04.01.2020
 */
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
//        si 指向当前要分配地cookies
        int gi=0, si=0, gl=g.length, sl=s.length;
        while (gi < gl && si < sl) {
            int greed=g[gi];
            while (si < sl) {
                if (s[si] >= greed) {
                    si++;
                    gi++;
                    break;
                } else {
                    si++;
                }
            }
        }
        return gi;
    }

    @Test
    public void sort() {
        int[] arrray=new int[]{21, 12, 1, 3, 2};
        System.out.println(Arrays.toString(quickSort(arrray, 0, arrray.length - 1)));
    }

    private int[] quickSort(int[] array, int l, int r) {
        if (l >= r) {
            return array;
        }
        final int partition=partition(array, l, r);
        quickSort(array, l, partition - 1);
        quickSort(array, partition + 1, r);
        return array;
    }

    private int partition(int[] array, int l, int r) {
//        [l,r]
        int guard=array[l];
//        (maxR,r] > guard
        int maxR=r;
        for (int i=l + 1; i <= maxR; ) {
            if (array[i] < guard) {
                i++;
            } else {
                swap(array, i, maxR);
                maxR--;
            }
        }
        if (maxR > l) {
            swap(array, l, maxR);
        }
        return maxR;
    }

    private void swap(int[] array, int l, int r) {
        int old=array[l];
        array[l]=array[r];
        array[r]=old;
    }
}
