package com.code.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @author wezhyn
 * @since 08.15.2020
 */
public class DeliveryTakeaway {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt(), m = in.nextInt();
            int[][] takeaways = new int[m][2];
            for (int i = 0; i < m; i++) {
                takeaways[i][0] = in.nextInt();
                takeaways[i][1] = in.nextInt();
            }
            UF uf = new UF(n + 1);
            for (int[] takeaway : takeaways) {
                uf.union(takeaway[0], takeaway[1]);
            }
            List<List<Integer>> results = new ArrayList<>(n);
            for (int i = 0; i <= n; i++) {
                results.add(new ArrayList<>());
            }
            final int[] ufIds = uf.getIds();
            for (int i = 1; i <= n; i++) {
                if (ufIds[i] > 0) {
                    results.get(ufIds[i]).add(i);
                }
            }
            print(results);
        }
    }

    private static void print(List<List<Integer>> results) {
        int result = 0;
        final StringBuilder stringBuilder = new StringBuilder();
        for (List<Integer> list : results) {
            if (!list.isEmpty()) {
                result++;
                for (int j = 0; j < list.size(); j++) {
                    stringBuilder.append(list.get(j));
                    if (j != list.size() - 1) {
                        stringBuilder.append(" ");
                    } else {
                        stringBuilder.append("\n");
                    }
                }
            }
        }
        System.out.println(result);
        System.out.println(stringBuilder);

    }

    private static class UF {
        private final int[] ids;
        int n;

        public UF(int n) {
            this.n = n;
            this.ids = new int[n];
            for (int i = 0; i < n; i++) {
                ids[i] = -i;
            }
        }


        public int find(int _p) {
            int p = _p;
            while (p != ids[p]) {
                p = ids[p];
            }
            return p;
        }

        public void standard(int p) {
            if (ids[p] < 0) {
                ids[p] = -ids[p];
            }
        }

        public void union(int p, int q) {
            standard(p);
            standard(q);
            int pr = p > q ? find(q) : find(p);
            int qr = p > q ? find(p) : find(q);
            if (pr == qr) {
                return;
            }
            ids[qr] = pr;
        }

        public int[] getIds() {
            return ids;
        }

    }

}
