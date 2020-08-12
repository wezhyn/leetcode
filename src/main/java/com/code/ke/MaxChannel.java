package com.code.ke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 给定n 个节点，m条边
 * u v a b
 * u - v 之间的距离是 C<sup>b</sup><sub>a</sub>
 * 使用KruskalMst 算出最大距离
 * <p>
 * 40%
 * 最后1分钟判断出：
 * 1. C<sup>b</sup><sub>a</sub> 超出最大值 nic(1000) 为0
 *
 * @author wezhyn
 * @since 08.11.2020
 */
public class MaxChannel {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                int n = in.nextInt(), m = in.nextInt();
                List<long[]> channels = loadNums(n, m, in);
                channels.sort((t1, t2) -> Math.toIntExact(t2[2] - t1[2]));
                UF uf = new UF(n + 1);
                long result = 0;
                for (long[] channel : channels) {
                    final int u = (int) channel[0];
                    final int v = (int) channel[1];
                    if (u <= n && v <= n && !uf.connected(u, v)) {
                        result += channel[2];
                        uf.union(u, v);
                    }
                }
                boolean notCon = false;
                for (int i = 1; i <= n; i++) {
                    if (!uf.connected(i, n)) {
                        notCon = true;
                        break;
                    }
                }
                if (notCon) {
                    System.out.println(-1);
                } else {
                    System.out.println((result % MOD));
                }
            }
        }
    }

    private static List<long[]> loadNums(int n, int m, Scanner in) {
        List<long[]> nums = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = in.nextInt(), v = in.nextInt();
            int a = in.nextInt(), b = in.nextInt();
            long[] pair = new long[]{u, v, compute(a, b)};
            nums.add(pair);
        }
        return nums;
    }

    private static long compute(int a, int b) {
        return ((nic(a) / (nic(b) * nic(a - b))) % MOD);
    }

    private static long nic(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
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
