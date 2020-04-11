package com.examination.four_ten.one;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] houses=new int[n];
        for (int i=0; i < n; i++) {
            houses[i]=scanner.nextInt();
            scanner.nextInt();
        }
        Arrays.sort(houses);
        int ava=(int) Arrays.stream(houses).average().getAsDouble();
        int l=houses[0], r=houses[n - 1];
        int min=Integer.MAX_VALUE;
        boolean isLeftMore=houses[n/2] < ava;
        if (isLeftMore) {
            r=ava;
        } else {
            l=ava;
        }
        for (int i=r; i >l; i--) {
            final int acc=acculate(houses, i);
            if (acc > min) {
                break;
            }else {
                min=Math.min(min, acculate(houses, i));
            }
        }
        System.out.println(min);
        l=houses[0];
        r=houses[n - 1];
        min=Integer.MAX_VALUE;
        for (int i=l; i < r; i++) {
            min=Math.min(min, acculate(houses, i));
        }
        System.out.println(min);
    }

    public static int acculate(int[] houses, int middle) {
        return Arrays.stream(houses).map(i->Math.abs(i - middle))
                .sum();
    }
}
