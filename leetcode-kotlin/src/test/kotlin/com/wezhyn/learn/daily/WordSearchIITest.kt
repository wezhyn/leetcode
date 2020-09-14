package com.wezhyn.learn.daily

import com.wezhyn.learn.twoPrimitiveArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 08.16.2020
 */
class WordSearchIITest {

    @Test
    fun findWords() {
        assertEquals(listOf("oath", "eat"), WordSearchII().findWords("""
              ['o','a','a','n'],
              ['e','t','a','e'],
              ['i','h','k','r'],
              ['i','f','l','v']
        """.twoPrimitiveArray { it[1] }, arrayOf("oath", "pea", "eat", "rain")))
    }
}