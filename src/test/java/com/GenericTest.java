package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 08.07.2020
 */
public class GenericTest {


    @Test
    public void binary1Bit() {
        assertEquals(32, numberOf1(-1));
        assertEquals(2, numberOf1(6));
    }

    private int numberOf1(int _n) {
        int count = 0;
        int n = _n;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    @Test
    public void numberEquals() {
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);
    }
}
