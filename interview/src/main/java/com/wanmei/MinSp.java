package com.wanmei;

import java.util.*;

/**
 * @author wezhyn
 * @since 08.25.2020
 */
public class MinSp {
    public static void main(String[] args) {
        int[][] weight = new int[6][];

        String[] pointsStr = {"V1", "V2", "V3", "V4", "V5", "V6"};
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < pointsStr.length; i++) {
            String[] valuesStr = input.nextLine().split(" ");
            int[] values = new int[valuesStr.length];
            for (int j = 0; j < valuesStr.length; j++) {
                values[j] = Integer.parseInt(valuesStr[j]);
            }
            weight[i] = values;
        }
        input.close();

        method(weight, pointsStr);
    }

    // Dijkstra
    public static void method(int[][] weight, String[] pointsStr) {

//        u,v,w 根据 w 进行排序
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(t -> t[2]));
        boolean[] visited = new boolean[pointsStr.length];
        int[] disTo = new int[pointsStr.length];
        Arrays.fill(disTo, Integer.MAX_VALUE);
        disTo[0] = 0;
        queue.add(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] minPath = queue.poll();
            int v = minPath[1];
            if (visited[v]) {
                continue;
            }
            visited[v] = true;
            final List<int[]> reachable = reachable(weight, v, visited);
            for (int[] reach : reachable) {
//                到达v的新距离
                int newDis = disTo[reach[0]] + reach[2];
                if (newDis < disTo[reach[1]]) {
                    disTo[reach[1]] = newDis;
                    queue.add(reach);
                }
            }
        }
        for (int i = 1; i < disTo.length; i++) {
            if (disTo[i] == Integer.MAX_VALUE) {
                System.out.println("9999");
            } else {
                System.out.println(disTo[i]);
            }
        }
    }

    private static List<int[]> reachable(int[][] weight, int v, boolean[] visited) {
        List<int[]> results = new ArrayList<>();
        for (int i = 0; i < weight[v].length; i++) {
            if (!visited[i] && weight[v][i] > 0) {
                results.add(new int[]{v, i, weight[v][i]});
            }
        }
        return results;
    }
}
