package com.code.netease;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * 给出n个物品，每个物品都有自己的价值，每个物品只有一件，这些物品需要分给两个人，要求分配完之后，两个人的物品价值相同。
 * 分配完成之后，会丢弃剩下的物品，求最少要丢弃多少物品
 * <p>
 * 使用如下的背包，解决80%，TEL
 * <p>
 * 网上AC办法，回溯法：
 * public static void a3(int[] item,int index,int x,int y,int r){
 * if(index == item.length){
 * if(x == y)
 * res = Math.min(r,res);
 * return;
 * }
 * a3(item,index+1,x+item[index],y,r)
 * a3(item,index+1,x,y+item[index],r);
 * a3(item,index+1,x,y,r+item[index]);
 * }
 *
 * @author wezhyn
 * @since 08.08.2020
 */
public class DivideGoods {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();
            for (int i = 0; i < T; i++) {
                int n = in.nextInt();
                int[] goods = new int[n];
                for (int j = 0; j < n; j++) {
                    goods[j] = in.nextInt();
                }
                Arrays.sort(goods);
                System.out.println(minThrow(goods));
            }

        }
    }

    private static int minThrow(int[] goods) {
        int maxThrow = (int) (Math.pow(2, goods.length) - 1);
        List<Integer> results = new ArrayList<>();
        for (int thr = 0; thr <= maxThrow; thr++) {
            if (backpack(goods, thr)) {
                results.add(thr);
            }
        }
        int min = Integer.MAX_VALUE;
        for (Integer integer : results) {
            int result = 0;
            for (int k = 0; k < goods.length; k++) {
                if (isThrow(k, integer)) {
                    result += goods[k];
                }
            }
            min = Math.min(min, result);
        }
        return min == Integer.MAX_VALUE ? 0 : min;

    }

    /**
     * 通过 0-1 背包检查当前数组能否构成一个相等的元素
     *
     * @param goods goods
     * @param thr   1 表示丢弃第1个 3表示丢弃 1和2 具体看二进制表现
     * @return true
     */
    public static boolean backpack(int[] goods, Integer thr) {
        int sum = 0;
        for (int i = 0; i < goods.length; i++) {
            if (!isThrow(i, thr)) {
                sum += goods[i];
            }
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < goods.length; i++) {
            int good = goods[i];
            if (!isThrow(i, thr)) {
                for (int j = sum; j >= good; j--) {
                    dp[j] = dp[j] | dp[j - good];
                }
            }
        }
        return dp[sum];

    }

    public static boolean isThrow(int i, int thr) {
        return (((1 << i)) & thr) != 0;
    }

}
