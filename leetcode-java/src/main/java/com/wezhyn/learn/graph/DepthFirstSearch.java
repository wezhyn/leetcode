package com.wezhyn.learn.graph;

/**
 * 深度优先搜索
 * * 可以用来判断图是否连通，因为任意一个连接的图，任意一个节点到其他任意节点都是连通的
 * * 单点路劲问题：s到给定v是否连通
 *
 * @author wezhyn
 * @since 04.29.2020
 */
public class DepthFirstSearch implements SimpleSearch {

    private boolean[] marked;
    private int count;
    private int start;

    public DepthFirstSearch(Graph g, int s) {
        this.start = s;
        marked = new boolean[g.vNums()];
        dfs(g, s);
    }

    public void dfs(Graph g, int v) {

        marked[v] = true;
        count++;
        for (int w : g.adj(v)) {
            if (!marked(w)) {
                dfs(g, w);
            }
        }
    }

    @Override
    public int getStart() {
        return start;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean marked(int v) {
        return this.marked[v];
    }
}
