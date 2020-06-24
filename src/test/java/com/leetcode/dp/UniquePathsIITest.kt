package com.leetcode.dp

import com.twoPrimitiveArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.24.2020
 */
class UniquePathsIITest {

    @Test
    fun uniquePathsWithObstacles() {
        assertEquals(2, UniquePathsII().uniquePathsWithObstacles(
                """  [0,0,0], [0,1,0], [0,0,0]""".twoPrimitiveArray { it.toInt() }
        ))
    }
}