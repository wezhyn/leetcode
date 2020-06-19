package com.leetcode.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * Atomic 通解
 *
 * @author wezhyn
 * @since 04.15.2020
 */
public class ZeroEvenOdd {
    private int n;
    private AtomicInteger count = new AtomicInteger(0);
    private volatile int currentCount = 1;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (currentCount <= n) {
            if (count.compareAndSet(0, 1)) {
                printNumber.accept(0);
                if (currentCount % 2 == 0) {
                    count.set(2);
                } else {
                    count.set(4);
                }
            } else {
                Thread.yield();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (currentCount <= n) {
            if (count.compareAndSet(2, 3)) {
                printNumber.accept(currentCount++);
                count.set(0);
            } else {
                Thread.yield();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (currentCount <= n) {
            if (count.compareAndSet(4, 5)) {
                printNumber.accept(currentCount++);
                count.set(0);
            } else {
                Thread.yield();

            }
        }
    }
}
