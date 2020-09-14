package com.wezhyn.learn.lcof

import com.wezhyn.learn.createListNodes
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.30.2020
 */
class RemoveNthNodeFromEndOfListTest {

    @Test
    fun removeNthFromEnd() {
        assertEquals(createListNodes(), RemoveNthNodeFromEndOfList().removeNthFromEnd(
                createListNodes(1), 1))
        assertEquals(createListNodes(1, 2), RemoveNthNodeFromEndOfList().removeNthFromEnd(
                createListNodes(1, 2, 3), 1))
        assertEquals(createListNodes(1, 2, 3, 5), RemoveNthNodeFromEndOfList().removeNthFromEnd(
                createListNodes(1, 2, 3, 4, 5), 2))
    }
}