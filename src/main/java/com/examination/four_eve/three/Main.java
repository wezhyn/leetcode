package com.examination.four_eve.three;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int round=scanner.nextInt();
        for (int roundI=0; roundI < round; roundI++) {
            int n=scanner.nextInt();
            int[] aArray=createArray(n, scanner);
            int[] vArray=createArray(n, scanner);
            Queue<Integer> prepareList=new ArrayDeque<>(n);
            for (int i : aArray) {
                prepareList.add(i);
            }
//            key: i,value:index
            int min=dfs(aArray, createArrayMap(aArray), vArray, prepareList, new int[n], 0, 0);
            System.out.println(min);
        }
    }

    public static int dfs(int[] originArray, HashMap<Integer, Integer> originMap, int[] vArray, Queue<Integer> originQueue, int[] prepareArray, int index, int sum) {
        int originValue=originArray[index];
        Set<Integer> visited=new HashSet<>();
        int m=Integer.MAX_VALUE;
        while (originQueue.peek()!=null && visited.size() < originArray.length - index) {
            final Integer pop=originQueue.poll();
            if (pop!=originValue) {
                prepareArray[index]=pop;
                sum+=vArray[originMap.get(pop)]*Math.abs(index - originMap.get(pop));
                if (originQueue.size()==0) {
                    originQueue.add(pop);
                    return sum;
                } else if (!visited.contains(pop)) {
                    int r=dfs(originArray, originMap, vArray, originQueue, prepareArray, index + 1, sum);
                    m=Math.min(m, r);
                    visited.add(pop);
                }
                originQueue.offer(pop);
            } else {
                originQueue.offer(pop);
                visited.add(pop);
            }
        }
        return m;
    }

    private static HashMap<Integer, Integer> createArrayMap(int[] array) {
        HashMap<Integer, Integer> c=new HashMap<>();
        for (int i=0; i < array.length; i++) {
            c.put(array[i], i);
        }
        return c;
    }

    public static int[] createArray(int n, Scanner scanner) {
        int[] aArray=new int[n];
        for (int i=0; i < n; i++) {
            aArray[i]=scanner.nextInt();
        }
        return aArray;
    }
}
