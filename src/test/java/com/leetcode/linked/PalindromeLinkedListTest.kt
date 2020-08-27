package com.leetcode.linked

import com.ListNode
import com.oneSingleNode
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.14.2020
 */
class PalindromeLinkedListTest {

    @Test
    fun isPalindrome() {
        assertTrue(PalindromeLinkedList().isPalindrome("2->2->3->3->2->2".oneSingleNode<ListNode>(delimiters = "->") { it.toInt() }))
        assertTrue(PalindromeLinkedList().isPalindrome("2->2".oneSingleNode<ListNode>(delimiters = "->") { it.toInt() }))
        assertTrue(PalindromeLinkedList().isPalindrome("2".oneSingleNode<ListNode>(delimiters = "->") { it.toInt() }))
        assertFalse(PalindromeLinkedList().isPalindrome("1->2->2->3".oneSingleNode<ListNode>(delimiters = "->") { it.toInt() }))
        assertFalse(PalindromeLinkedList().isPalindrome("1->2->2".oneSingleNode<ListNode>(delimiters = "->") { it.toInt() }))
        assertTrue(PalindromeLinkedList().isPalindrome("1->2->2->1".oneSingleNode<ListNode>(delimiters = "->") { it.toInt() }))
    }
}