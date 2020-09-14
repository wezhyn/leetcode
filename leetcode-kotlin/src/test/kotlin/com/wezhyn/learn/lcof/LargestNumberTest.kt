package com.wezhyn.learn.lcof

import com.wezhyn.learn.intArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.11.2020
 */
class LargestNumberTest {

    @Test
    fun largestNumber() {
        assertEquals("12121", LargestNumber().largestNumber("121,12".intArray()))
        assertEquals("828247", LargestNumber().largestNumber("8247,82".intArray()))
        assertEquals("828247", LargestNumber().largestNumber("8247,82".intArray()))
        assertEquals("8249824", LargestNumber().largestNumber("8249,824".intArray()))
        assertEquals("8248824", LargestNumber().largestNumber("8248,824".intArray()))
        assertEquals("8248824", LargestNumber().largestNumber("824,8248".intArray()))
        assertEquals("22112111", LargestNumber().largestNumber("2,1,11,12,21".intArray()))
        assertEquals("3", LargestNumber().largestNumber("3".intArray()))
        assertEquals("2200", LargestNumber().largestNumber("2,0,20".intArray()))
        assertEquals("210", LargestNumber().largestNumber("2,10".intArray()))
        assertEquals("9534330", LargestNumber().largestNumber("3,30,34,5,9".intArray()))
    }
}