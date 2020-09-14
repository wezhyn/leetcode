package com.wezhyn.learn.linked


import com.wezhyn.learn.ListNode
import com.wezhyn.learn.oneSingleNode
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 08.21.2020
 */
class ReorderListTest {

    @Test
    fun reorderList() {
        val node = "1->2->3->4->5".oneSingleNode<ListNode>(delimiters = "->") { it.toInt() }
        ReorderList().reorderList(node)
        assertEquals("1->5->2->4->3".oneSingleNode<ListNode>(delimiters = "->") { it.toInt() }, node)
    }
}