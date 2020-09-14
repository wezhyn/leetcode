package com.wezhyn.learn.recursive

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 08.18.2020
 */
class KthSymbolIGrammarTest {

    @Test
    fun kthGrammar() {
        assertEquals(1, KthSymbolIGrammar().kthGrammar(30, 124562))
        assertEquals(1, KthSymbolIGrammar().kthGrammar(2, 2))
        assertEquals(0, KthSymbolIGrammar().kthGrammar(2, 1))
        assertEquals(0, KthSymbolIGrammar().kthGrammar(1, 1))
    }
}