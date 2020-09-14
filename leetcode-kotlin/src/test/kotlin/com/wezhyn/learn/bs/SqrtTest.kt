package com.wezhyn.learn.bs

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 08.19.2020
 */
class SqrtTest {

    @Test
    fun mySqrt() {
        Sqrt().mySqrt(131073)
        for (i in 1..1000000) {
            assertEquals("err $i", Math.sqrt(i.toDouble()).toInt(), Sqrt().mySqrt(i))
        }
    }
}