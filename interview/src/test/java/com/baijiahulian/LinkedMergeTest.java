package com.baijiahulian;

import org.junit.Test;

/**
 * @author wezhyn
 * @since 09.14.2020
 */
public class LinkedMergeTest {

    @Test
    public void mergeTwoLists() {
        Node one = new Node();
        one.data = 1;
        one.next = new Node();
        one.next.data = 4;

        Node two = new Node();
        two.data = 1;
        two.next = new Node();
        two.next.data = 2;
        new LinkedMerge().mergeTwoLists(
                one, two
        );
    }
}