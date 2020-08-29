package com.code.zhongan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 交友问题：
 *
 * @author wezhyn
 * @since 08.29.2020
 */
public class FriendRequestNum {
    /**
     * age[A] >= age[B]
     * age[A] <(age[B]-7)*2
     *
     * @param ages int整型一维数组
     * @return int整型
     */
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        List<Pair> noRepeatNum = new ArrayList<>();
        Pair last = new Pair(-1, 0);
        for (int age : ages) {
            if (last.age != age) {
                last = new Pair(age, 1);
                noRepeatNum.add(last);
            } else {
                last.ageNum++;
            }
        }
        final int size = noRepeatNum.size();
        int result = 0;
        for (int i = size - 1; i >= 0; i--) {
            Pair pairI = noRepeatNum.get(i);
            int ageA = pairI.age;
            if (pairI.ageNum > 1) {
                result += 2 * pairI.ageNum;
            }
            for (int j = i - 1; j >= 0; j--) {
                Pair pairJ = noRepeatNum.get(j);
                int ageB = pairJ.age;
                if (ageA < (ageB - 7) * 2) {
                    result += pairI.ageNum * pairJ.ageNum;
                }
            }
        }
        return result;
    }

    private static class Pair {
        int age;
        int ageNum;

        public Pair(int age, int ageNum) {
            this.age = age;
            this.ageNum = ageNum;
        }
    }
}
