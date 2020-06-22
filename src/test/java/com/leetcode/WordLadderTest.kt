package com.leetcode

import com.leetcode.graph.WordLadder
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.19.2020
 */
class WordLadderTest {

    @Test
    fun ladderLength() {
        assertEquals(3, WordLadder().ladderLength("hot", "dog", listOf("hot", "dog", "dot")))
        assertEquals(2, WordLadder().ladderLength("a", "g", listOf("g")))
        assertEquals(5, WordLadder().ladderLength("hit", "cog", listOf(
                "hot", "dot", "dog", "lot", "log", "cog"
        )))
        assertEquals(0, WordLadder().ladderLength("hit", "cog", listOf(
                "hot", "dot", "log", "cog"
        )))
    }
}