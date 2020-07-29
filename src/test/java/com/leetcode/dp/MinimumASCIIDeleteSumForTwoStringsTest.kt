package com.leetcode.dp

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.28.2020
 */
class MinimumASCIIDeleteSumForTwoStringsTest {

    @Test
    fun minimumDeleteSum() {

        assertEquals(403, MinimumASCIIDeleteSumForTwoStrings().minimumDeleteSum("delete", "leet"))
        assertEquals(231, MinimumASCIIDeleteSumForTwoStrings().minimumDeleteSum("sea", "eat"))
    }
}