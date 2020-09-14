package com.fiveeight;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wezhyn
 * @since 08.31.2020
 */
public class CommonStringTest {

    @Test
    public void findCommonString() {
        ArrayList<ArrayList<String>> results = new ArrayList<>();
        results.add(new ArrayList<>(Arrays.asList("you", "bette", "you", "a")));
//        results.add(new ArrayList<>(Arrays.asList("you", "better", "you", "b")));
//        results.add(new ArrayList<>(Arrays.asList("you", "you", "better", "c")));
        System.out.println(
                new CommonString().findCommonString(results)
        );
    }
}