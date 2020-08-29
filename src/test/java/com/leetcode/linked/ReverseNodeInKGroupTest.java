package com.leetcode.linked;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class ReverseNodeInKGroupTest {

    @Test
    public void reverseKGroup() {
        assertEquals(ListNode.create(2, 1, 4, 3, 5), new ReverseNodeInKGroup().reverseKGroup(
                ListNode.create(1, 2, 3, 4, 5), 2
        ));
    }
}