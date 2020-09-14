package com.wezhyn.learn.lcof

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.18.2020
 */
class NumsEqualsSubscriptTest {

    @Test
    fun findSubscript() {
        assertEquals(-1, NumsEqualsSubscript().findSubscript(intArrayOf(-3, -1, 1, 4, 5)))
        assertEquals(3, NumsEqualsSubscript().findSubscript(intArrayOf(-3, -1, 1, 3, 5)))
    }
}