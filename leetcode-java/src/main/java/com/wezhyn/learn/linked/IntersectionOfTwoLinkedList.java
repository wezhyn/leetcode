package com.wezhyn.learn.linked;

/**
 * 双指针法，当遍历完A后，开始从B头节点开始遍历
 * 假设两个链表间存在交叉节点，A 到交叉节点距离 a, 交叉节点到末尾距离 x ，B 到达交叉节点的距离为b
 * 则两个指针最多移动 a+x+b 个距离，如果x==0 ，则不相交，则最后退出位置为 null
 *
 * @author wezhyn
 * @since 08.29.2020
 */
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ca = headA, cb = headB;
        while (ca != cb) {
            ca = ca.next;
            cb = cb.next;
            if (ca == null && cb == null) {
//                不相交
                return null;
            } else if (ca == null) {
                ca = headB;
            } else if (cb == null) {
                cb = headA;
            }
        }
        return ca;
    }
}
