package com.code.zhongan;

/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class NumDisplacement {
    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            int num = start + 2 * i;
            result ^= num;
        }
        return result;
    }
}
