package com.examination.fourZeroNine.four;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author wezhyn
 * @since 04.09.2020
 */
public class Main {
    private static int[] to=new int[]{0, 3, 6};
    public HashMap<Integer, Integer> c=new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            int k=scanner.nextInt();
            System.out.println(toI(k));
        }
    }

    public static int toI(int k) {
        if (k < 3) {
            return to[k];
        }
        return toI(k - 1) ;
    }
}
