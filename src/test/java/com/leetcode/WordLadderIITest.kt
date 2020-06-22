package com.leetcode

import com.leetcode.graph.WordLadderII
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.19.2020
 */
class WordLadderIITest {

    @Test
    fun findLadders() {
        assertEquals(listOf(listOf("red", "ted", "tad", "tax"), listOf("red", "ted", "tex", "tax"), listOf("red", "rex", "tex", "tax")),
                WordLadderII().findLadders("red", "tax", listOf("ted", "tex", "red", "tax", "tad", "den", "rex", "pee")))
        assertEquals(listOf(listOf("hit", "hot", "dot", "dog", "cog"), listOf("hit", "hot", "lot", "log", "cog")),
                WordLadderII().findLadders("hit", "cog", listOf(
                        "hot", "dot", "dog", "lot", "log", "cog"
                )))
        assertEquals(listOf(listOf("hot", "dot", "dog")), WordLadderII().findLadders("hot", "dog", listOf("hot", "dog", "dot")))
        assertEquals(listOf(listOf("a", "g")), WordLadderII().findLadders("a", "g", listOf("g")))
        assertEquals(listOf<List<String>>(), WordLadderII().findLadders("hit", "cog", listOf(
                "hot", "dot", "log", "cog"
        )))
    }
}