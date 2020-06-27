package com.offer

import com.twoPrimitiveArray
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.27.2020
 */
class WordSearchTest {

    @Test
    fun exist() {
        assertFalse(WordSearch().exist("""  ['B']""".twoPrimitiveArray { it[1] }, "A"))
        assertFalse(WordSearch().exist("""  ['A','B','C','E']""".twoPrimitiveArray { it[1] }, "ABA"))
        assertFalse(WordSearch().exist("""  ['A','B','C','E']""".twoPrimitiveArray { it[1] }, "ABA"))
        assertTrue(WordSearch().exist("""  ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E']""".twoPrimitiveArray { it[1] }, "ABCCED"))
        assertTrue(WordSearch().exist("""  ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E']""".twoPrimitiveArray { it[1] }, "SEE"))
        assertFalse(WordSearch().exist("""  ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E']""".twoPrimitiveArray { it[1] }, "ABCB"))
    }
}