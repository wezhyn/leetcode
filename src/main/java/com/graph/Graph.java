package com.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 算法（第4版）图论数据结构
 *
 * @author wezhyn
 * @since 04.29.2020
 */
public class Graph {

    /**
     * 顶点数目
     */
    private final int v;
    /**
     * 边数
     */
    private int e;

    /**
     * 邻接表
     */
    private List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int v) {
        this.v = v;
        this.e = 0;
        this.adj = (ArrayList<Integer>[]) new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public Graph(Scanner in) {
        this(in.nextInt());
        int eIn = in.nextInt();
        for (int i = 0; i < eIn; i++) {
            addEdge(in.nextInt(), in.nextInt());
        }
    }

    public int eNums() {
        return this.e;
    }

    public int vNums() {
        return this.v;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        e++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }


    public int maxDegree() {
        return Stream.of(adj).map(List::size).max(Comparator.comparingInt(Integer::intValue))
                .orElse(0);
    }

    public int degree(int v) {
        return adj[v].size();
    }

}
