package com

import org.junit.Test

/**
 * @author wezhyn
 * @since 07.01.2020
 */
class SortKtTest {

    @Test
    fun quickSort() {
        val array = arrayOf(1, 3, 2, 5, 3, 6, 2, 10, 23, 54, 2, 3, 43, 23, 12, 14)

        quickSort(array)
        println(array.contentDeepToString())
    }
}