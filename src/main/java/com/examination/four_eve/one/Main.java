package com.examination.four_eve.one;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wezhyn
 * @since 04.11.2020
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int round=scanner.nextInt();
        for (int t=0; t < round; t++) {
            int m=scanner.nextInt();
            int l=scanner.nextInt();
            int[][] produceArray=new int[m][m];
            for (int i=0; i < m; i++) {
                for (int j=0; j < m; j++) {
                    produceArray[i][j]=scanner.nextInt();
                }
            }
            int x=scanner.nextInt(), y=scanner.nextInt();
            final Map<Double, AtomicInteger> produce=distance(produceArray, x, y, m);
            boolean end=false;
            produceArray=null;
            while (!end) {
                boolean isFlag=false;
                for (Double d : produce.keySet()) {
                    if (d <= l) {
                        final AtomicInteger re=produce.remove(d);
                        l+=re.get();
                        isFlag=true;
                        break;
                    }
                }
                if (!isFlag) {
                    end=true;
                }
            }
            System.out.println(l);
        }
    }

    public static Map<Double, AtomicInteger> distance(int[][] produceArray, int x, int y, int m) {
        Map<Double, AtomicInteger> dis=new HashMap<>();
        for (int i=0; i < m; i++) {
            for (int j=0; j < m; j++) {
                if (produceArray[i][j] > 0) {
                    Double d=Math.sqrt(Math.pow(x - i, 2) + Math.pow(y - j, 2));
                    AtomicInteger l=new AtomicInteger(produceArray[i][j]);
                    AtomicInteger absent=dis.putIfAbsent(d, l);
                    if (absent!=null) {
                        absent.getAndAdd(produceArray[i][j]);
                    }
                }
            }
        }
        return dis;
    }
}
