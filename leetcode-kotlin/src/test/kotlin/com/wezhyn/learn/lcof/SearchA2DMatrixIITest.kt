package com.wezhyn.learn.lcof

import com.wezhyn.learn.twoPrimitiveArray
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.26.2020
 */
class SearchA2DMatrixIITest {

    @Test
    fun searchMatrix() {
        assertTrue(SearchA2DMatrixII().searchMatrix("""  [1,   4,  7, 11, 15], [2,   5,  8, 12, 19], [3,   6,  9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30]""".twoPrimitiveArray { it.toInt() },
                1))
        assertTrue(SearchA2DMatrixII().searchMatrix("""  [1,   4,  7, 11, 15], [2,   5,  8, 12, 19], [3,   6,  9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30]""".twoPrimitiveArray { it.toInt() },
                2))
        assertTrue(SearchA2DMatrixII().searchMatrix("""  [1,   4,  7, 11, 15], [2,   5,  8, 12, 19], [3,   6,  9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30]""".twoPrimitiveArray { it.toInt() },
                18))
        assertTrue(SearchA2DMatrixII().searchMatrix("""  [1,   4,  7, 11, 15], [2,   5,  8, 12, 19], [3,   6,  9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30]""".twoPrimitiveArray { it.toInt() },
                30))
        assertFalse(SearchA2DMatrixII().searchMatrix("""  [1,   4,  7, 11, 15], [2,   5,  8, 12, 19], [3,   6,  9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30]""".twoPrimitiveArray { it.toInt() },
                25))
    }
}