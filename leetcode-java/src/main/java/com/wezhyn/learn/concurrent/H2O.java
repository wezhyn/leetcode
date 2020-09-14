package com.wezhyn.learn.concurrent;

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
