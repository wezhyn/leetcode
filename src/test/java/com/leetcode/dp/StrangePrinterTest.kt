package com.leetcode.dp

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.21.2020
 */
class StrangePrinterTest {

    @Test
    fun strangePrinter() {
        assertEquals(4, StrangePrinter().strangePrinter("ababbc"))
        assertEquals(2, StrangePrinter().strangePrinter("aba"))
        assertEquals(0, StrangePrinter().strangePrinter(""))
        assertEquals(0, StrangePrinter().strangePrinter(""))
        assertEquals(1, StrangePrinter().strangePrinter("a"))
        assertEquals(3, StrangePrinter().strangePrinter("abc"))
        assertEquals(2, StrangePrinter().strangePrinter("aaabbb"))
    }
}