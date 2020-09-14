package com.wezhyn.learn.daily;

import org.junit.Test;

/**
 * @author wezhyn
 * @since 09.09.2020
 */
public class CombinationSumTest {

    @Test
    public void combinationSum() {

        System.out.println(new CombinationSum().combinationSum(
                new int[]{2, 3, 6, 7}, 7
        ));
    }
}