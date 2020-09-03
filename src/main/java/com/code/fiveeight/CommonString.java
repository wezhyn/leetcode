package com.code.fiveeight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wezhyn
 * @since 08.31.2020
 */
public class CommonString {
    /**
     * @param values string字符串ArrayList<ArrayList<>>
     * @return string字符串ArrayList
     */
    public ArrayList<String> findCommonString(ArrayList<ArrayList<String>> values) {
        if (values == null) {
            return new ArrayList<>();
        } else if (values.size() == 1) {
            return values.get(0);
        }
        Set<String> presCommons = new HashSet<>(values.get(0));
        Set<String> curCommons = new HashSet<>();
        ArrayList<String> results = new ArrayList<>();
        for (int i = 1; i < values.size(); i++) {
            final ArrayList<String> strings = values.get(i);
            for (String str : strings) {
                if (presCommons.contains(str)) {
                    if (i == values.size() - 1) {
                        results.add(str);
                    }
                    curCommons.add(str);
                }
            }
            presCommons.clear();
            Set<String> tmp = curCommons;
            curCommons = presCommons;
            presCommons = tmp;
        }
        return results;
    }
}
