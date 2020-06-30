package com.leetcode.top.interview.medium;

import com.ListNode;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 06.30.2020
 */
public class AddTwoNumbersTest {

    @Test
    public void addTwoNumbers() {
        ListNode l1 = new ListNode(2);
        l1.setNext(new ListNode(4));
        l1.getNext().setNext(new ListNode(3));

        ListNode l2 = new ListNode(5);
        l2.setNext(new ListNode(6));
        System.out.println(AddTwoNumbers.addTwoNumbers(l1, l2));
    }
}