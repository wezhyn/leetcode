package com.wezhyn.learn.graph

import com.wezhyn.learn.twoPrimitiveArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.22.2020
 */
class BusRoutesTest {

    @Test
    fun numBusesToDestination() {
        assertEquals(-1, BusRoutes().numBusesToDestination(
                "[7,12],[4,5,15],[6],[15,19],[9,12,13]".twoPrimitiveArray { it.toInt() }, 15, 12
        ))
        assertEquals(1, BusRoutes().numBusesToDestination(
                "[1, 2, 7], [3, 6, 7]".twoPrimitiveArray { it.toInt() }, 2, 7
        ))
        assertEquals(1, BusRoutes().numBusesToDestination(
                "[1, 2, 7], [3, 6, 7]".twoPrimitiveArray { it.toInt() }, 7, 2
        ))

        assertEquals(4, BusRoutes().numBusesToDestination(
                "[1, 2,3],[4,2,5],[5,2,4],[3,6],[6,8]".twoPrimitiveArray { it.toInt() }, 5, 8
        ))
        assertEquals(2, BusRoutes().numBusesToDestination(
                "[1, 2, 7], [3, 6, 7]".twoPrimitiveArray { it.toInt() }, 1, 6
        ))
    }
}