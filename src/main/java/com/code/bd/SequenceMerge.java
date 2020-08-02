package com.code.bd;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 为了获取第n小的元素，可以利用 最小堆弹出第 n 个小元素
 *
 * @author wezhyn
 * @since 08.02.2020
 */
public class SequenceMerge {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            SequenceGenerate[] generates = new SequenceGenerate[n];
            PriorityQueue<Pair> roundQueue = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                generates[i] = new SequenceGenerate(in);
                roundQueue.add(new Pair(generates[i].next(), i));
            }
            int targetN = in.nextInt();
            long s = 0;
            for (int i = 0; i < targetN; i++) {
                final Pair curMin = roundQueue.poll();
                s = curMin.sequence;
                curMin.sequence = generates[curMin.sequenceIndex].next();
                roundQueue.add(curMin);
            }
            System.out.println(s);
        }
    }

    private static class Pair implements Comparable<Pair> {

        long sequence;
        int sequenceIndex;

        public Pair(long sequence, int sequenceIndex) {
            this.sequence = sequence;
            this.sequenceIndex = sequenceIndex;
        }

        @Override
        public int compareTo(Pair o) {
            return sequence - o.sequence > 0 ? 1 : -1;
        }
    }

    private static class SequenceGenerate {

        private static final int SEQUENCE_LENGTH = 8;
        int[] aSequences = new int[SEQUENCE_LENGTH];
        int n = 1;

        public SequenceGenerate(Scanner scanner) {
            for (int i = 0; i < SEQUENCE_LENGTH; i++) {
                aSequences[i] = scanner.nextInt();
            }
        }


        public long next() {
            long result = 0;
            for (int i = 0; i < SEQUENCE_LENGTH; i++) {
                result += aSequences[i] * Math.pow(n, SEQUENCE_LENGTH - 1 - i);
            }
            n++;
            return result;
        }

    }

}
