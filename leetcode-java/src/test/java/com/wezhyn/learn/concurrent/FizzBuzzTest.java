package com.wezhyn.learn.concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author wezhyn
 * @since 09.14.2020
 */
public class FizzBuzzTest {

    @Test
    public void test() throws InterruptedException {
        final ExecutorService service = Executors.newFixedThreadPool(4);
        FizzBuzz fizzBuzz = new FizzBuzz();
        service.submit(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.submit(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.submit(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> {
                    System.out.println("fiz buzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.submit(() -> {
            try {
                fizzBuzz.number(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        TimeUnit.SECONDS.sleep(2);
    }
}