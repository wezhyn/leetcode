package com.leetcode.aprilchallenge;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 *
 * @author wezhyn
 * @since 04.11.2020
 */
public class MinStack {


    private PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
    private Stack<Integer> stack=new Stack<>();
    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    public void push(int x) {
        stack.push(x);
        priorityQueue.offer(x);
    }

    public void pop() {
        final Integer pop=stack.pop();
        if (pop!=null) {
            priorityQueue.remove(pop);
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return priorityQueue.peek();
    }

}
