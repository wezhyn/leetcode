package com.zhongan;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class SymmetryNumber {

    private static final Set<Integer> SYMMETRYS = new HashSet<>();

    static {
        SYMMETRYS.add(1);
        SYMMETRYS.add(6);
        SYMMETRYS.add(8);
        SYMMETRYS.add(9);
    }

    public boolean isStrobogrammatic(String num) {
        for (int i = 0; i < num.length(); i++) {
            int digit = (num.charAt(i)) - '0';
            if (!SYMMETRYS.contains(digit)) {
                return false;
            }
        }
        return true;
    }
}
