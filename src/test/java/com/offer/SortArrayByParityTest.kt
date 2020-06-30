package com.offer

import com.onePrimitiveArray
import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.30.2020
 */
class SortArrayByParityTest {

    @Test
    fun sortArrayByParity() {
        assertArrayEquals("0,1".onePrimitiveArray { it.toInt() },
                SortArrayByParity().sortArrayByParity("0,1".onePrimitiveArray { it.toInt() }))
        assertArrayEquals("0,1".onePrimitiveArray { it.toInt() },
                SortArrayByParity().sortArrayByParity("1,0".onePrimitiveArray { it.toInt() }))
        assertArrayEquals("2,4,6".onePrimitiveArray { it.toInt() },
                SortArrayByParity().sortArrayByParity("2,4,6".onePrimitiveArray { it.toInt() }))
        assertArrayEquals("1,3,5".onePrimitiveArray { it.toInt() },
                SortArrayByParity().sortArrayByParity("1,3,5".onePrimitiveArray { it.toInt() }))
        assertArrayEquals("2,2,2,3,5,1".onePrimitiveArray { it.toInt() },
                SortArrayByParity().sortArrayByParity("2,1,2,3,5,2".onePrimitiveArray { it.toInt() }))
        assertArrayEquals("2,4,3,1".onePrimitiveArray { it.toInt() },
                SortArrayByParity().sortArrayByParity("3,1,2,4".onePrimitiveArray { it.toInt() }))
    }
}