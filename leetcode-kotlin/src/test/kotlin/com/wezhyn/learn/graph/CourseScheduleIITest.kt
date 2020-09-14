package com.wezhyn.learn.graph

import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.21.2020
 */
class CourseScheduleIITest {

    @Test
    fun findOrder() {
        assertArrayEquals(IntArray(0), CourseScheduleII().findOrder(4, arrayOf(
                intArrayOf(2, 0),
                intArrayOf(1, 0),
                intArrayOf(3, 1),
                intArrayOf(3, 2),
                intArrayOf(1, 3)
        )))
        assertArrayEquals(IntArray(0), CourseScheduleII().findOrder(6, arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(4, 5),
                intArrayOf(4, 2),
                intArrayOf(3, 4))))
        assertArrayEquals(intArrayOf(0, 1), CourseScheduleII().findOrder(2, arrayOf(intArrayOf(1, 0))))
        assertArrayEquals(IntArray(0), CourseScheduleII().findOrder(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))))
    }
}