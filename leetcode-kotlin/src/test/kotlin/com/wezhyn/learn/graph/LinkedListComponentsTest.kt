package com.wezhyn.learn.graph

import com.wezhyn.learn.ListNode
import com.wezhyn.learn.onePrimitiveArray
import com.wezhyn.learn.oneSingleNode
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
                "0->3->2->1".oneSingleNode<ListNode>(delimiters = "->"), "2, 0, 3".onePrimitiveArray { it.toInt() }
        ))
    }
}