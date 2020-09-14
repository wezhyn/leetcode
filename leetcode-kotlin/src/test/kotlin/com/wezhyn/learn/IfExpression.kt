package com.wezhyn.learn

import org.junit.Test
import kotlin.test.assertEquals

/**
 *
 * @author wezhyn
 * @since 06.25.2020
 *
 */
class IfExpression {

    @Test
    fun test() {
        assertEquals(2, add(1, 1))
        assertEquals(8, add(2, 4))
        assertEquals(4, add(1, 2))
        assertEquals(8, add(1, 6))
    }

    private fun add(i: Int, j: Int): Int = 2 + if (i == 1) 0 else {
        i
    } + if (j == 1) 0 else j


}