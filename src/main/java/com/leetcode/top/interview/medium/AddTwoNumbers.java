package com.leetcode.top.interview.medium;

import com.leetcode.top.interview.ListNode;

/**
 *
 * 通过添加一个伪头节点解决
 * @author wezhyn
 * @since 03.10.2020
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);

        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        System.out.println(addTwoNumbers(l1,l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum=new ListNode(0);
        ListNode sumCur=sum;
        ListNode cur1=l1;
        ListNode cur2=l2;

        while (cur1!=null || cur2!=null) {
            int cur1Value=cur1==null ? 0 : cur1.val;
            int cur2Value=cur2==null ? 0 : cur2.val;
            int value=cur1Value + cur2Value + sum.val;
            if (value >= 10) {
                sumCur.next=new ListNode(value - 10);
                sum.val=1;
            } else {
                sumCur.next=new ListNode(value);
                sum.val=0;
            }
            sumCur=sumCur.next;
            cur1=cur1==null ? null : cur1.next;
            cur2=cur2==null ? null : cur2.next;
        }
        if (sum.val!=0) {
            sumCur.next=new ListNode(sum.val);
        }
        return sum.next;
    }

}
