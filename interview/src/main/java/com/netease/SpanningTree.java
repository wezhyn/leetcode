package com.netease;

import java.util.Arrays;
import java.util.Scanner;


/**
 * @author wezhyn
 * @since 08.08.2020
 */
public class SpanningTree {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                int n = in.nextInt(), m = in.nextInt();
                int[][] edges = new int[n + 1][n + 1];
                for (int[] edge : edges) {
                    Arrays.fill(edge, Integer.MAX_VALUE);
                }
                UF uf = new UF(n + 1);
                for (int i = 0; i < m; i++) {
                    int s = in.nextInt();
                    int e = in.nextInt();
                    int w = in.nextInt();
                    int min = Math.min(s, e);
                    int max = Math.max(s, e);
                    if (uf.connected(min, max)) {
                        edges[min][max] = Math.min(edges[min][max], w);
                    } else {
                        uf.union(min, max);
                        edges[min][max] = w;
                    }
                }
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                int r = Integer.MAX_VALUE;
                for (int mi = 0; mi < n; mi++) {
                    for (int mj = mi; mj <= n; mj++) {
                        uf.unUnion(mi, mj);
                        for (int i = 1; i <= n; i++) {
                            for (int j = i; j <= n; j++) {
                                if (edges[i][j] != Integer.MAX_VALUE && uf.connected(i, j)) {
                                    max = Math.max(max, edges[i][j]);
                                    min = Math.min(min, edges[i][j]);
                                }
                            }
                        }
                        uf.union(mi, mj);
                        r = Math.min(r, max - min);
                    }
                }
                System.out.println(r);
            }
        }
    }

    private static class UF {
        private final int[] ids;
        int n;

        public UF(int n) {
            this.n = n;
            this.ids = new int[n];
            for (int i = 0; i < n; i++) {
                ids[i] = i;
            }
        }


        public int find(int _p) {
            int p = _p;
            while (p != ids[p]) {
                p = ids[p];
            }
            return p;
        }

        public void unUnion(int p, int q) {
            int pr = find(p);
            int qr = find(q);
            if (pr == qr && pr != p) {
                ids[p] = p;
            } else {
                ids[q] = q;
            }
        }

        public void union(int p, int q) {
            int pr = find(p);
            int qr = find(q);
            if (pr == qr) {
                return;
            }
            ids[pr] = qr;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
    }
}
