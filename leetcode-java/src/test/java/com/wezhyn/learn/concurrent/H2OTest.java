package com.wezhyn.learn.concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author wezhyn
 * @since 09.14.2020
 */
public class H2OTest {

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
}