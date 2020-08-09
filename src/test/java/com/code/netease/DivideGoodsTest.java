package com.code.netease;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author wezhyn
 * @since 08.08.2020
 */
public class DivideGoodsTest {

    @Test
    public void equals() {
        assertFalse(DivideGoods.backpack(new int[]{5, 15, 30, 30, 60}, 0));
        assertFalse(DivideGoods.backpack(new int[]{5, 15, 21}, 0));
        assertTrue(DivideGoods.backpack(new int[]{5, 15, 20}, 0));
    }

    @Test
    public void isThrow() {
        assertFalse(DivideGoods.isThrow(2, 10));
        assertTrue(DivideGoods.isThrow(0, 3));
        assertTrue(DivideGoods.isThrow(1, 2));
        assertTrue(DivideGoods.isThrow(1, 3));
    }
}