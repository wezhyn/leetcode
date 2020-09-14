package com.wezhyn.learn

import org.junit.Test

/**
 * @author wezhyn
 * @since 07.01.2020
 */
class SortKtTest {

    @Test
    fun quickSort() {
        print(arrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1))
        print(arrayOf(-1, -2, -3, -5, -4, -6, -7))
        print(arrayOf(1, 1, -1, 0, 3, 2, 5, 3, 6, 2, 10, 23, 54, 2, 3, 43, 23, 12, 14))
    }

    private fun print(array: Array<Int>) {
        mergeSort(array)
        println(array.contentDeepToString())
    }
}