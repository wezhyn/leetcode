package com.code.bd;

import org.junit.Test;

/**
 * @author wezhyn
 * @since 09.03.2020
 */
public class MaxNumTest {

    @Test
    public void main() {
        int r = 5;
        while (r < Integer.MAX_VALUE) {
            r = r * 10 + 5;
            if (r % 9 == 0) {
                System.out.println(r);
            }
        }
    }
}