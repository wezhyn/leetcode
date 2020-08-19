package com.leetcode.sub

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 08.19.2020
 */
class FindLongestAwesomeSubstringTest {

    @Test
    fun longestAwesome() {
        assertEquals(8, FindLongestAwesomeSubstring().longestAwesome("32424113"))
    }
}