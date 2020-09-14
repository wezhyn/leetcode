package com.wezhyn.learn.tree;

import org.junit.Test;

/**
 * @author wezhyn
 * @since 09.04.2020
 */
public class BinaryTreePathsTest {

    @Test
    public void binaryTreePaths() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new BinaryTreePaths().binaryTreePaths(root));
    }
}