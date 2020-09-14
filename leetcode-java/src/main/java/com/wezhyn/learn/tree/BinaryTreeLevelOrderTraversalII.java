package com.wezhyn.learn.tree;

import java.util.*;

/**
 * @author wezhyn
 * @since 09.06.2020
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Stack<List<Integer>> lists = new Stack<>();
        Queue<TreeNode> treeNodes = new LinkedList<>();
        TreeNode flag = new TreeNode(-1);
        treeNodes.add(root);
        treeNodes.add(flag);
        List<Integer> r = new ArrayList<>();
        while (!treeNodes.isEmpty()) {
            final TreeNode node = treeNodes.poll();
            if (node == flag) {
                lists.add(r);
                r = new ArrayList<>();
                if (treeNodes.isEmpty()) {
                    break;
                }
                treeNodes.add(flag);
            } else {
                if (node.left != null) {
                    treeNodes.add(node.left);
                }
                if (node.right != null) {
                    treeNodes.add(node.right);
                }
                r.add(node.val);
            }
        }
        List<List<Integer>> results = new ArrayList<>();
        while (!lists.isEmpty()) {
            results.add(lists.pop());
        }
        return results;

    }
}
