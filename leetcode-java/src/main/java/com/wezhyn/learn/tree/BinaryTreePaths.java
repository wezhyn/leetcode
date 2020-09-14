package com.wezhyn.learn.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wezhyn
 * @since 09.04.2020
 */
public class BinaryTreePaths {

    private List<String> results;

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        results = new ArrayList<>();
        dfs(root, new ArrayList<>(), 0);
        return results;
    }

    /**
     * len 代表当前要插入的位置
     *
     * @param node  节点
     * @param lists 字符串路径
     * @param len   当前长度
     */
    private void dfs(TreeNode node, List<Integer> lists, int len) {
        if (node.left != null || node.right != null) {
            setPath(lists, len, node.val);
        }
        if (node.left == null && node.right == null) {
            setPath(lists, len, node.val);
            addPath(lists, len);
            return;
        }
        if (node.left != null) {
            dfs(node.left, lists, len + 1);
        }
        if (node.right != null) {
            dfs(node.right, lists, len + 1);
        }
    }

    private void setPath(List<Integer> path, int len, int target) {
        if (len >= path.size()) {
            path.add(target);
        } else {
            path.set(len, target);
        }
    }

    private void addPath(List<Integer> lists, int len) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= len; i++) {
            sb.append(lists.get(i));
            if (i != len) {
                sb.append("->");
            }
        }
        results.add(sb.toString());
    }

}
