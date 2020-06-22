package com.leetcode

import com.leetcode.graph.CourseSchedule
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.20.2020
 */
class CourseScheduleTest {

    @Test
    fun canFinish() {
        assertEquals(false, CourseSchedule().canFinish(4, arrayOf(
                intArrayOf(2, 0),
                intArrayOf(1, 0),
                intArrayOf(3, 1),
                intArrayOf(3, 2),
                intArrayOf(1, 3)
        )))
        assertEquals(false, CourseSchedule().canFinish(6, arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(4, 5),
                intArrayOf(4, 2),
                intArrayOf(3, 4))))
        assertEquals(true, CourseSchedule().canFinish(2, arrayOf(intArrayOf(1, 0))))
        assertEquals(false, CourseSchedule().canFinish(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))))
    }
}