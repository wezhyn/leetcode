package com.offer

import com.onePrimitiveArray
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.01.2020
 */
class PermutationsTest {

    @Test
    fun permute() {
        println(
                Permutations().permute("1,2,3,4,5,6,7".onePrimitiveArray { it.toInt() })
        )
    }
}