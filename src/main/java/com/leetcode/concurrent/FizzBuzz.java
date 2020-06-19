package com.leetcode.concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author wezhyn
 * @since 04.15.2020
 */
public class FizzBuzz {

    int n;
    private AtomicInteger count;

    public FizzBuzz() {
        this.n = 3;
        this.count = new AtomicInteger(1);
    }

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

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        int c;
        while ((c = count.get()) <= n) {
            if (c % 3 == 0 && c % 5 != 0) {
                printFizz.run();
                count.getAndIncrement();
                Thread.yield();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {

        int c;
        while ((c = count.get()) <= n) {
            if (c % 3 != 0 && c % 5 == 0) {
                printBuzz.run();
                count.getAndIncrement();
                Thread.yield();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

        int c;
        while ((c = count.get()) <= n) {
            if (c % 3 == 0 && c % 5 == 0) {
                printFizzBuzz.run();
                count.getAndIncrement();
                Thread.yield();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        int c;
        while ((c = count.get()) <= n) {
            if (c % 3 != 0 && c % 5 != 0) {
                printNumber.accept(c);
                count.getAndIncrement();
                Thread.yield();
            }
        }
    }
}
