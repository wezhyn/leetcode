package com.examination.fourZeroNine.second;


import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            int n=scanner.nextInt();
            int r=0;
            HashMap<Integer, Integer> initN=new HashMap<>();
            int[] result=new int[n];
            for (int i=0; i < n; i++) {
                initN.put(scanner.nextInt(), i);
            }
            for (int i=0; i < n; i++) {
                result[i]=scanner.nextInt();
            }
            for (int i=0; i < result.length - 1; i++) {
                int cur=result[i];
                for (int j=i + 1; j < result.length; j++) {
                    int af=result[j];
                    if (initN.get(cur) > initN.get(af)) {
                        r++;
                        break;
                    }
                }
            }
            System.out.println(r);
        }
    }
}
