package com.youzan;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author wezhyn
 * @since 08.20.2020
 */
public class PalindromeLinkedTest {

    @Test
    public void isPalindrome() {
        assertTrue(new PalindromeLinked().isPalindrome(create(1, 2, 1)));
        assertTrue(new PalindromeLinked().isPalindrome(create(1, 2, 2, 1)));
    }

    private PalindromeLinked.ListNode create(int... arrs) {
        PalindromeLinked.ListNode h = new PalindromeLinked.ListNode();
        PalindromeLinked.ListNode cur = h;
        for (int i : arrs) {
            cur.next = new PalindromeLinked.ListNode();
            cur.next.val = i;
            cur = cur.next;
        }
        return h.next;
    }

}