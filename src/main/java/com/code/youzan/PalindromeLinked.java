package com.code.youzan;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wezhyn
 * @since 08.20.2020
 */
public class PalindromeLinked {
    /**
     * 判断是否为回文链表
     *
     * @param head ListNode类 链表头
     * @return bool布尔型
     */
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        ListNode h = head;
        while (h != null) {
            deque.addLast(h.val);
            h = h.next;
        }
        while (deque.size() != 0 && deque.size() != 1) {
            int l = deque.removeFirst();
            int r = deque.removeLast();
            if (l != r) {
                return false;
            }
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next = null;
    }
}
