package com.wezhyn.learn.graph

import com.wezhyn.learn.twoPrimitiveArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.22.2020
 */
class LongestIncreasingPathInAMatrixTest {

    @Test
    fun longestIncreasingPath() {
        assertEquals(2, LongestIncreasingPathInAMatrix().longestIncreasingPath(
                "[1,3,2]".twoPrimitiveArray { it.toInt() }
        ))
        assertEquals(4, LongestIncreasingPathInAMatrix().longestIncreasingPath(
                """[9,9,4],[6,6,8],[2,1,1]""".twoPrimitiveArray { it.toInt() }))
        assertEquals(5, LongestIncreasingPathInAMatrix().longestIncreasingPath(
                """  [3,4,5], [3,2,6], [2,2,7]""".twoPrimitiveArray { it.toInt() }))
    }
}