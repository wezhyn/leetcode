package com.wezhyn.learn.dp

import com.wezhyn.learn.twoPrimitiveArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.25.2020
 */
class NumMatrixTest {

    @Test
    fun sumRegion() {
        val numMatrix = NumMatrix("""  [3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]""".twoPrimitiveArray { it.toInt() })
        assertEquals(8, numMatrix.sumRegion(2, 1, 4, 3))
        assertEquals(11, numMatrix.sumRegion(1, 1, 2, 2))
        assertEquals(12, numMatrix.sumRegion(1, 2, 2, 4))
    }
}