package com.offer


/**
 *  A linked list is given such that each node contains an additional random pointer
 *  which could point to any node in the list or null.
 *
 *  https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 *  随机链表的难度在于拷贝后链表中的随机指针所指向的元素
 *  原链表为 N ，拷贝为 C
 *  为了使得能在O(1) 的时间内获取 N random 对象在 next 方向上的对象 N'
 *  常见的方法就是从头节点开始顺序查找 L 次，匹配N' ，之后在 C 上偏移 L ，指向C'
 *  为了缩短查找的时间，可以用Hashmap 将 N 与 C 进行关联，
 *  查找 N' 时，可以获取到对应 C‘
 *
 *
 *
 * @author wezhyn
 * @since 06.30.2020
 *
 */
class CopyListWithRandomPointer {

    private lateinit var map: HashMap<Node, Node>
    private fun copyRandomList(node: Node?): Node? {
        map = HashMap<Node, Node>()
        if (node == null) {
            return null
        }
        return build(node)
    }

    private fun build(nNode: Node): Node {
        var cNode = map.get(nNode)
        if (cNode != null) {
            return cNode
        }
        cNode = Node(nNode.`val`)
        map.put(nNode, cNode)
        if (nNode.next != null) {
            cNode.next = build(nNode.next!!)
        }
        if (nNode.random != null) {
            cNode.random = build(nNode.random!!)
        }
        return cNode
    }


    private class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
    }
}
