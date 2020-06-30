package com.leetcode.top.interview.medium;


import com.ListNode;

/**
 * 通过添加一个伪头节点解决
 *
 * @author wezhyn
 * @since 03.10.2020
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode sumCur = sum;
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while (cur1 != null || cur2 != null) {
            int cur1Value = cur1 == null ? 0 : cur1.getVal();
            int cur2Value = cur2 == null ? 0 : cur2.getVal();
            int value = cur1Value + cur2Value + sum.getVal();
            if (value >= 10) {
                sumCur.setNext(new ListNode(value - 10));
                sum.setVal(1);
            } else {
                sumCur.setNext(new ListNode(value));
                sum.setVal(0);
            }
            sumCur = sumCur.getNext();
            cur1 = cur1 == null ? null : cur1.getNext();
            cur2 = cur2 == null ? null : cur2.getNext();
        }
        if (sum.getVal() != 0) {
            sumCur.setNext(new ListNode(sum.getVal()));
        }
        return sum.getNext();
    }

}
