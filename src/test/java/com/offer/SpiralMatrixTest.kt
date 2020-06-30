package com.offer

import com.oneList
import com.twoPrimitiveArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.30.2020
 */
class SpiralMatrixTest {

    @Test
    fun spiralOrder() {
        assertEquals("1,2,3,5,1,1,9,8,7,4,5,6".oneList { it.toInt() },
                SpiralMatrix().spiralOrder(""" [ 1, 2, 3,5 ], [ 4, 5, 6,1 ], [ 7, 8, 9,1 ]""".twoPrimitiveArray { it.toInt() }))
    }
}