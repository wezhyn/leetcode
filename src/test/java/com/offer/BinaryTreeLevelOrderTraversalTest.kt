package com.offer

import com.treeNodeWithNull
import com.twoList
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.30.2020
 */
class BinaryTreeLevelOrderTraversalTest {

    @Test
    fun levelOrder() {
        assertEquals(""" [3], [9,20], [15,7] """.twoList { it.toInt() },
                BinaryTreeLevelOrderTraversal().levelOrder("3,9,20,null,null,15,7".treeNodeWithNull { it.toInt() }))
    }
}