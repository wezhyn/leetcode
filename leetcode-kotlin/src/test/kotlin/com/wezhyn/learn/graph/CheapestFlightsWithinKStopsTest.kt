package com.wezhyn.learn.graph


import com.wezhyn.learn.twoPrimitiveArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.21.2020
 */
class CheapestFlightsWithinKStopsTest {

    @Test
    fun findCheapestPrice() {
        assertEquals(200, CheapestFlightsWithinKStops().findCheapestPrice(3,
                "[0,1,100],[1,2,100],[0,2,500]".twoPrimitiveArray { it.toInt() }, 0, 2, 1
        ))
        assertEquals(500, CheapestFlightsWithinKStops().findCheapestPrice(3,
                "[0,1,100],[1,2,100],[0,2,500]".twoPrimitiveArray { it.toInt() }, 0, 2, 0
        ))
        assertEquals(1000, CheapestFlightsWithinKStops().findCheapestPrice(4,
                "[0,1,100],[1,2,100],[0,2,500],[0,3,1000],[2,3,200]".twoPrimitiveArray { it.toInt() }, 0, 3, 0
        ))
        assertEquals(700, CheapestFlightsWithinKStops().findCheapestPrice(4,
                "[0,1,100],[1,2,100],[0,2,500],[0,3,1000],[2,3,200]".twoPrimitiveArray { it.toInt() }, 0, 3, 1
        ))
        assertEquals(400, CheapestFlightsWithinKStops().findCheapestPrice(4,
                "[0,1,100],[1,2,100],[0,2,500],[0,3,1000],[2,3,200]".twoPrimitiveArray { it.toInt() }, 0, 3, 2
        ))
    }
}