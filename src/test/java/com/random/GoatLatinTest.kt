package com.random

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 08.20.2020
 */
class GoatLatinTest {

    @Test
    fun toGoatLatin() {
        assertEquals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa", GoatLatin().toGoatLatin(
                "The quick brown fox jumped over the lazy dog"
        ))
        assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa", GoatLatin().toGoatLatin("I speak Goat Latin"))
    }
}