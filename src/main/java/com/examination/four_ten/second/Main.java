package com.examination.four_ten.second;

import java.util.Scanner;

/**
 * @author wezhyn
 * @since 04.10.2020
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        for (int ti=0; ti < t; ti++) {
            int n=scanner.nextInt(), m=scanner.nextInt(), c=scanner.nextInt();
            int[][] space=new int[n][m];
            for (int ni=0; ni < n; ni++) {
                for (int mi=0; mi < m; mi++) {
                    space[ni][mi]=-1;
                }
            }
            int[] cT=new int[c];
            for (int ci=0; ci < c; ci++) {
                cT[ci]=scanner.nextInt();
            }
            boolean end=false;
            for (int ni=0; ni < n&&!end; ni++) {
                for (int mi=0; mi < m&&!end; mi++) {
                    final int colorTop=findTop(space, ni, mi);
                    final int colorLeft=findLeft(space, ni, mi);
                    final int choose=choose(cT, colorTop, colorLeft);
                    if (choose==-1) {
                        end=true;
                        System.out.println("NO");
                    }
                }
            }
            if (!end) {
                System.out.println("YES");
            }
        }
    }

    public static int choose(int[] colors, int top, int left) {
        for (int i=0; i < colors.length; i++) {
            if (i!=top && i!=left) {
                if (colors[i] > 0) {
                    colors[i]=colors[i] - 1;
                    return i;
                }
            }
        }
        return -1;
    }

    public static int findTop(int[][] space, int n, int m) {
        if (n==0) {
            return -1;
        }
        return space[n - 1][m];
    }

    public static int findLeft(int[][] space, int n, int m) {
        if (m==0) {
            return -1;
        }
        return space[n][m - 1];
    }

    public static int findRight(int[][] space, int n, int m) {
        if (m==0) {
            return -1;
        }
        return space[n][m + 1];
    }
}
