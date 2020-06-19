package com.leetcode.concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode.com/problems/building-h2o/
 *
 * @author wezhyn
 * @since 04.15.2020
 */
public class H2O {

    private ReentrantLock lock;
    private Condition notHydrogen;
    private Condition notOxygen;
    private volatile int availableHydrogen;

    public H2O() {
        lock = new ReentrantLock();
        notOxygen = lock.newCondition();
        notHydrogen = lock.newCondition();
        availableHydrogen = 2;
    }

    @Test
    public void test() throws InterruptedException {
        final ExecutorService service = Executors.newCachedThreadPool();
        H2O h2O = new H2O();
        service.submit(() -> {
            for (int i = 0; i < 20; i++) {
                service.submit(() -> {
                    try {
                        h2O.hydrogen(() -> System.out.println("H"));
                    } catch (InterruptedException e) {
                    }
                });
            }
        });
        service.submit(() -> {
            for (int i = 0; i < 10; i++) {
                service.submit(() -> {
                    try {
                        h2O.oxygen(() -> System.out.println("O"));
                    } catch (InterruptedException e) {
                    }
                });
            }
        });
        TimeUnit.SECONDS.sleep(5);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        try {
            lock.lock();
            while (true) {
                if (availableHydrogen > 0) {
                    releaseHydrogen.run();
                    availableHydrogen--;
                    notHydrogen.signal();
                    break;
                } else {
                    notOxygen.await();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        try {
            lock.lock();
            while (true) {
                if (availableHydrogen == 0) {
                    releaseOxygen.run();
                    availableHydrogen = 2;
                    notOxygen.signalAll();
                    break;
                }
                notHydrogen.await();
            }
        } finally {
            lock.unlock();
        }
    }

}
