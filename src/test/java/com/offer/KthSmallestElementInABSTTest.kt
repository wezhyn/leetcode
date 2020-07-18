package com.offer

import com.treeNodeWithNull
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.18.2020
 */
class KthSmallestElementInABSTTest {

    @Test
    fun kthSmallest() {
        assertEquals(4, KthSmallestElementInABST().kthSmallest(
                "3,1,4,null,2".treeNodeWithNull { it.toInt() }, 4))
        assertEquals(3, KthSmallestElementInABST().kthSmallest(
                "3,1,4,null,2".treeNodeWithNull { it.toInt() }, 3))
        assertEquals(2, KthSmallestElementInABST().kthSmallest(
                "3,1,4,null,2".treeNodeWithNull { it.toInt() }, 2))
        assertEquals(1, KthSmallestElementInABST().kthSmallest(
                "3,1,4,null,2".treeNodeWithNull { it.toInt() }, 1))
    }
}