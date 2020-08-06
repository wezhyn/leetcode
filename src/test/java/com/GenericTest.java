package com;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author wezhyn
 * @since 08.04.2020
 */
public class GenericTest {
    public static void main(String[] args) throws InterruptedException {
    }

    @Test
    public void jmmVariableRead() throws InterruptedException {
        MyRun myRun = new MyRun(false);
        new Thread(myRun).start();
        Thread.sleep(1000); // 等待线程执行
        myRun.setStop(true);
        System.out.println("main start to stop");
        Thread.sleep(10000);
        System.out.println("main stop");
    }

    @Test
    public void forkJoinWithSum() throws ExecutionException, InterruptedException {
        final ForkJoinTask<Integer> task = ForkJoinPool.commonPool().submit(new SumRecursiveTask(1, 100));
        System.out.println(task.get());
    }

    @Test
    public void StringIntern() {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

    @Test
    public void stackOverflowError() {
        System.out.println(stackOverflow(20000, 1, 1));
    }

    private int stackOverflow(int i, int y, double z) {
        if (i == 1) {
            return 1;
        }
        return stackOverflow(i - 1, y, z) + y;
    }

    public static class MyRun implements Runnable {

        private boolean stop;

        MyRun(boolean status) {
            this.stop = status;
        }

        @Override
        public void run() {
            while (!stop) {
            }
            System.out.println("stop");
        }

        public void setStop(boolean stop) {
            this.stop = stop;
        }
    }

    private static class SumRecursiveTask extends RecursiveTask<Integer> {

        private int start;
        private int end;

        public SumRecursiveTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start < 10) {
                return (start + end) * (end - start + 1) / 2;
            }
            int middle = (start + end) / 2;
            SumRecursiveTask one = new SumRecursiveTask(start, middle);
            SumRecursiveTask other = new SumRecursiveTask(middle + 1, end);
            invokeAll(one, other);
            return one.join() + other.join();
        }
    }
}
