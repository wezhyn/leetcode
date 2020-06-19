package com.graph;

import java.util.Arrays;

/**
 * 深度优先搜索路径的出来的路径不一定为最短路径
 *
 * @author wezhyn
 * @since 04.29.2020
 */
public class DepthFirstPath implements SimplePathSearch {

    private final Graph graph;

    public DepthFirstPath(Graph graph) {
        this.graph = graph;
    }


    @Override
    public String path(int s, int v) {
        int[] path = new int[graph.vNums()];
        boolean[] marked = new boolean[graph.vNums()];
        Arrays.fill(path, -1);
        path[0] = s;
        final boolean dfs = dfs(s, v, s, marked, path, 1);
        if (dfs) {
            StringBuilder sb = new StringBuilder();
            for (int i : path) {
                if (i == -1) {
                    break;
                }
                sb.append(i).append("-");
            }
            return sb.toString();
        }
        return "";
    }

    private boolean dfs(int s, int v, int w, boolean[] marked, int[] path, int index) {
        marked[w] = true;
        boolean end = false;
        for (int wi : this.graph.adj(w)) {
            if (end) {
                return true;
            }
            if (!marked[wi]) {
                path[index] = wi;
                if (v == wi) {
                    end = true;
                    return end;
                } else {
                    end = dfs(s, v, wi, marked, path, index + 1);
                }
            }
        }
        return end;
    }

    @Override
    public boolean hasPath(int s, int v) {
        return false;
    }
}
