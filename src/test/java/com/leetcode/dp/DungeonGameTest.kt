package com.leetcode.dp

import com.twoPrimitiveArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.23.2020
 */
class DungeonGameTest {

    @Test
    fun calculateMinimumHP() {
        assertEquals(1, DungeonGame().calculateMinimumHP(
                arrayOf(intArrayOf(0))
        ))
        assertEquals(1, DungeonGame().calculateMinimumHP(
                emptyArray()
        ))
        assertEquals(7, DungeonGame().calculateMinimumHP(
                """[-2,-3,3],[-5,-10,1],[10,30,-5]""".twoPrimitiveArray { it.toInt() }
        ))
        assertEquals(6, DungeonGame().calculateMinimumHP(
                """[-2,-3,3],[-5,-10,1]""".twoPrimitiveArray { it.toInt() }
        ))
    }
}