package com.code.chitu;

import java.util.*;

/**
 * @author wezhyn
 * @since 08.07.2020
 */
public class MinimumPunishment {
    /**
     * Dijkstra
     *
     * @param n     节点总数；节src/main/java/com/code/bd编号从 1 开始，⼀一直到 n，共有 n 个；
     * @param edges ⽆无向图的边 s-e w
     * @param start 路径的开始
     * @param end   路径的末端
     * @return 最小代价
     */
    int minPath(int n, int[][] edges, int start, int end) {
        List<List<int[]>> adjacent = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adjacent.add(new ArrayList<>());
        }
//        创建邻接矩阵
        for (int[] edge : edges) {
            List<int[]> list = adjacent.get(edge[0]);
            list.add(edge);
        }
        return dijkstra(adjacent, start, end, n);

    }


    private int dijkstra(List<List<int[]>> adjacent, int start, int end, int n) {
        int[] distances = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(t -> t[2]));
        queue.add(new int[]{start, start, 0});
        while (!queue.isEmpty()) {
            final int[] pair = queue.poll();
            int source = pair[1];
            if (!visited[source]) {
                for (int[] edge : adjacent.get(source)) {
                    int target = edge[1];
                    int oldDis = distances[target];
                    int newDis = distances[source] | edge[2];
                    if (newDis < oldDis) {
                        distances[target] = newDis;
                        queue.add(edge);
                    }
                }
                visited[source] = true;
            }
        }
        return distances[end];
    }

}
