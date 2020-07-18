package com.offer

import com.treeNodeWithNull
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.18.2020
 */
class CheckAvlTreeTest {

    @Test
    fun isAvl() {
        assertFalse(CheckAvlTree().isAvl(
                "3,3,8,null,4".treeNodeWithNull { it.toInt() }
        ))
        assertFalse(CheckAvlTree().isAvl(
                "5,3,8,2,null,6,9,1,null".treeNodeWithNull { it.toInt() }
        ))
        assertTrue(CheckAvlTree().isAvl(
                "5,3,8,1,4,6,9".treeNodeWithNull { it.toInt() }
        ))
        assertFalse(CheckAvlTree().isAvl(
                "5,3,8,1,2,6,9".treeNodeWithNull { it.toInt() }
        ))
    }
}