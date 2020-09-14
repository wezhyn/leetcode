package com.wezhyn.learn.string

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 08.23.2020
 */
class StringArrangedTest {

    @Test
    fun checkInclusion() {
        assertTrue(StringArranged().checkInclusion("a", "aa"))
        assertTrue(StringArranged().checkInclusion("a", "ba"))
        assertTrue(StringArranged().checkInclusion("a", "ab"))
        assertTrue(StringArranged().checkInclusion("a", "a"))
        assertFalse(StringArranged().checkInclusion("ab", "eidboaoo"))
        assertTrue(StringArranged().checkInclusion("ab", "eidbaooo"))
    }
}