package com.wezhyn.learn.dp

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.29.2020
 */
class OutOfBoundaryPathsTest {

    @Test
    fun findPaths() {
        assertEquals(12, OutOfBoundaryPaths().findPaths(1, 3, 3, 0, 1))
    }
}