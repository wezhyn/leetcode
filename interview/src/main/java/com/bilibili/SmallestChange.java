package com.bilibili;

/**
 * @author wezhyn
 * @since 08.13.2020
 */
public class SmallestChange {
    private static final int MAX_CHANGE = 1024;
    private static final int[] CHANGES = new int[]{64, 16, 4, 1};

    public int GetCoinCount(int N) {
        int remain = 1024 - N;
        int result = 0;

        for (int i = 0; i < CHANGES.length; i++) {
            int cg = CHANGES[i];
            while (remain >= cg) {
                remain -= cg;
                result++;
            }
        }
        return result;
    }
}
