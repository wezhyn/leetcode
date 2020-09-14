package com.wezhyn.learn.lcof

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.27.2020
 */
class CutCordTest {

    @Test
    fun cur() {
        assertEquals(32, CutCord().cur(10, 5))
        assertEquals(18, CutCord().cur(8, 3))
    }

}