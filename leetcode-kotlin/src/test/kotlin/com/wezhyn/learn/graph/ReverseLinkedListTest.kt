package com.wezhyn.learn.graph


import com.wezhyn.learn.ListNode
import com.wezhyn.learn.oneSingleNode
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.13.2020
 */
class ReverseLinkedListTest {

    @Test
    fun reverseList() {
        ReverseLinkedListII().reverseBetween("1->2->3->4->5".oneSingleNode<ListNode>(delimiters = "->") { it.toInt() }, 2, 4)
    }
}