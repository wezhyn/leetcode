package com.leetcode

import com.leetcode.graph.ReconstructItinerary
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * @author wezhyn
 * @since 06.19.2020
 */
class ReconstructItineraryKtTest {

    @Test
    fun test() {
        assertEquals(ReconstructItinerary().findItinerary(listOf(listOf("JFK", "SFO"), listOf("JFK", "ATL"), listOf("SFO", "ATL"),
                listOf("ATL", "JFK"), listOf("ATL", "SFO"))), listOf("JFK", "ATL", "JFK", "SFO", "ATL", "SFO"))
        assertEquals(ReconstructItinerary().findItinerary(listOf(listOf("JFK", "KUL"), listOf("JFK", "NRT"), listOf("NRT", "JFK")))
                , listOf("JFK", "NRT", "JFK", "KUL"))


        assertEquals(ReconstructItinerary().findItinerary(listOf(listOf("MUC", "LHR"), listOf("JFK", "MUC"), listOf("SFO", "SJC"),
                listOf("LHR", "SFO"))), listOf("JFK", "MUC", "LHR", "SFO", "SJC"))
    }
}