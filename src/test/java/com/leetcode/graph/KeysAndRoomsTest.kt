package com.leetcode.graph

import com.twoList
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.22.2020
 */
class KeysAndRoomsTest {

    @Test
    fun canVisitAllRooms() {
        assertFalse(KeysAndRooms().canVisitAllRooms("""[1,3],[3,0,1],[2],[0]""".twoList { it.toInt() }))
        assertTrue(KeysAndRooms().canVisitAllRooms("""[1],[2],[3],[]""".twoList { it.toInt() }))
    }
}