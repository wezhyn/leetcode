package com.examination.foru_ei.two;

import java.util.*;

/**
 * @author wezhyn
 * @since 04.18.2020
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, List<Integer>> scope = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int to = in.nextInt();
            boolean isAdd = false;
            for (Integer m : scope.keySet()) {
                List<Integer> sortList = scope.get(m);
                Integer minIndex = findClose(start, sortList);
                Integer maxIndex = findClose(to, sortList);
                if (minIndex == -1 && maxIndex == -1) {
                    isAdd = true;
                    sortList.add(start);
                    sortList.add(to);
                    sortList.sort(Comparator.comparingInt(i2 -> i2));
                    break;
                } else if (minIndex != -1 && maxIndex != -1) {
                    continue;
                }
            }
            if (!isAdd) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(to);
                list.sort(Comparator.comparingInt(i2 -> i2));
                scope.put(to, list);
            }
        }
        System.out.println(scope);
        System.out.println(scope.size());
    }


    public static Integer findClose(int i, List<Integer> list) {
        int j;
        for (j = 0; j < list.size(); j++) {
            if (list.get(j) >= i) {
                return j;
            }
        }
        return -1;
    }

}
