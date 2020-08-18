package com.daily

import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 08.18.2020
 */
class DistributeCandiesToPeopleTest {

    @Test
    fun distributeCandies() {
        assertArrayEquals(intArrayOf(5, 2, 3), DistributeCandiesToPeople().distributeCandies(10, 3))
    }
}