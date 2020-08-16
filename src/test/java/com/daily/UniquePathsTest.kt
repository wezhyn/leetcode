package com.daily

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 08.16.2020
 */
class UniquePathsTest {

    @Test
    fun uniquePaths() {
        assertEquals(2000000000, UniquePaths().uniquePaths(50, 50))
        assertEquals(28, UniquePaths().uniquePaths(7, 3))
    }
}