package com.leetcode.aprilchallenge;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 04.06.2020
 */
public class BestTimeToBuyAndSellStockII {

    @Test
    public void test() {
        Assert.assertEquals(4,maxProfit(new int[]{1,2,3,4,5}));
        Assert.assertEquals(7, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        Assert.assertEquals(0,maxProfit(new int[]{7,6,4,3,1}));
        Assert.assertEquals(1,maxProfit(new int[]{1,2}));
    }

    public int maxProfit(int[] prices) {
//        [i,prices-2]
        int total=0;
        for (int i=0; i + 1 <= prices.length - 1; ) {
            int firstPrice=prices[i];
            int cur=prices[i];
            int next=prices[i + 1];
            if (cur <= next) {
                while (cur <= next && i + 1 < prices.length - 1) {
                    i++;
                    cur=prices[i];
                    next=prices[i + 1];
                }
                if (cur > next) {
                    total+=prices[i] - firstPrice;
                    i++;
                } else if (i + 1==prices.length-1) {
                    total+=prices[i+1] - firstPrice;
                    break;
                }
            } else {
                i++;
            }
        }
        return total;
    }
}
