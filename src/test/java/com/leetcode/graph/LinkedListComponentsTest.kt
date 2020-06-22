package com.leetcode.graph

import com.oneListNode
import com.onePrimitiveArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.22.2020
 */
class LinkedListComponentsTest {

    @Test
    fun numComponents() {
        assertEquals(1, LinkedListComponents().numComponents(
                "0->3->2->1".oneListNode(delimiters = "->"), "2, 0, 3".onePrimitiveArray { it.toInt() }
        ))
    }
}