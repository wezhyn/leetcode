package com.code.tecent;

import org.junit.Test;

/**
 * @author wezhyn
 * @since 08.14.2020
 */
public class ReverseLinkedTest {

    @Test
    public void reverseBetween() {
        System.out.println(new ReverseLinked().reverseBetween(create(new int[]{1, 2, 3, 4, 5}), 1, 5));
        System.out.println(new ReverseLinked().reverseBetween(create(new int[]{1, 2, 3, 4, 5}), 1, 4));
        System.out.println(new ReverseLinked().reverseBetween(create(new int[]{1, 2, 3, 4, 5}), 2, 4));
    }

    private ReverseLinked.ListNode create(int[] ints) {
        ReverseLinked.ListNode h = new ReverseLinked.ListNode(-1, null), cur = h;
        for (int i : ints) {
            final ReverseLinked.ListNode node = new ReverseLinked.ListNode(i, null);
            cur.next = node;
            cur = cur.next;
        }
        return h.next;
    }
}