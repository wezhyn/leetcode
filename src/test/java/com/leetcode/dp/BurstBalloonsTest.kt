package com.leetcode.dp

import com.onePrimitiveArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.23.2020
 */
class BurstBalloonsTest {

    @Test
    fun maxCoins() {
        assertEquals(167, BurstBalloons().maxCoins("3,1,5,8".onePrimitiveArray { it.toInt() }))
    }
}