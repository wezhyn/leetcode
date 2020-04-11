package com.examination.four_eve.two;

import java.util.*;

/**
 * @author wezhyn
 * @since 04.11.2020
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int round=scanner.nextInt();
        for (int t=0; t < round; t++) {
//            n:正整数个数，m操作数
            int n=scanner.nextInt(), m=scanner.nextInt();
            List<Set<Integer>> savedList=new ArrayList<>();
            HashMap<Integer, Integer> indexMap=new HashMap<>(n);
            for (int mi=0; mi < m; mi++) {
                int operate=scanner.nextInt();
                int x=scanner.nextInt();
//                        统一放在xIndex对应列表中
                Integer xIndex=indexMap.get(x);
                if (xIndex==null) {
                    xIndex=createCollection(x, savedList, indexMap);
                }
                switch (operate) {
                    case 1: {
                        int y=scanner.nextInt();
                        Integer yIndex=indexMap.get(y);
                        if (yIndex==null) {
                            savedList.get(xIndex).add(y);
                            indexMap.put(y, xIndex);
                        } else if (!xIndex.equals(yIndex)) {
//                            合并x,y数组
                            final Set<Integer> ySet=savedList.get(yIndex);
                            final Set<Integer> xSet=savedList.get(xIndex);
                            final Iterator<Integer> iterator=ySet.iterator();
                            while (iterator.hasNext()) {
                                Integer yi=iterator.next();
                                xSet.add(yi);
                                indexMap.put(yi, xIndex);
                                iterator.remove();
                            }
                        }
                        break;
                    }
                    case 2: {
                        final Set<Integer> xSet=savedList.get(xIndex);
                        if (xSet.size() > 1) {
                            xSet.remove(x);
                            createCollection(x, savedList, indexMap);
                        }
                        break;
                    }
                    case 3: {
                        System.out.println(savedList.get(xIndex).size());
                        break;
                    }
                    default: {
                    }
                }
            }
        }

    }

    public static Integer createCollection(int x, List<Set<Integer>> savedList, HashMap<Integer, Integer> indexMap) {
        Set<Integer> xSet=new HashSet<>();
        xSet.add(x);
        savedList.add(xSet);
        Integer xIndex=savedList.size() - 1;
        indexMap.put(x, xIndex);
        return xIndex;
    }
}
