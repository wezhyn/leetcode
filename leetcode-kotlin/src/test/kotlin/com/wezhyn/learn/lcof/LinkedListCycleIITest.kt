package com.wezhyn.learn.lcof

import com.wezhyn.learn.createListNodes
import org.junit.Test
import kotlin.test.assertEquals

/**
 * @author wezhyn
 * @since 06.30.2020
 */
class LinkedListCycleIITest {

    @Test
    fun detectCycle() {
        val nodes = createListNodes(3, 2, 0, -4)
        nodes?.next?.next?.next?.next = nodes?.next
        assertEquals(nodes?.next, LinkedListCycleII().detectCycle(nodes))
    }
}