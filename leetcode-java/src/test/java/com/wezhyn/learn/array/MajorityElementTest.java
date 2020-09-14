package com.wezhyn.learn.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class MajorityElementTest {

    @Test
    public void majorityElement() {
        assertEquals(2, new MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        assertEquals(3, new MajorityElement().majorityElement(new int[]{3, 5, 3}));
        assertEquals(3, new MajorityElement().majorityElement(new int[]{3, 2, 3}));
    }
}