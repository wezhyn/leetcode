package com.examination.four_twity_six.four;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author wezhyn
 * @since 04.26.2020
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        CustomQueue queue = new CustomQueue();
        for (int i = 0; i < n; i++) {
            String op = in.next();
            switch (op) {
                case "add": {
                    queue.push(in.nextInt());
                    break;
                }
                case "poll": {
                    queue.pop();
                    break;
                }
                case "peek": {
                    System.out.println(queue.peek());
                    break;
                }
            }
        }
    }

    public static class CustomQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int peek() {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }
    }
}
