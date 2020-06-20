package com

import java.util.*

/**
 *
 * 拓扑排序【有向图】：将有向图中的所有顶点排序，使得所有的有向边均从排在前面的元素指向排在后面的元素
 * 拓扑排序有如下的应用场景：
 * 应用       顶点      边
 * 任务调度    任务      优先级限制
 * 课程安排    课程      先导课限制
 * 继承       Java 类   extends 关系
 *
 * 课程安排：某校的选课系统规定，每门课可能有若干个先修课，如果要修读某一门课程，则必须要先修完所有的先修课才能修读。
 * 假设一个学生同时只能报一门课程那,n么选课系统允许他修完所有课程的顺序就是一个拓扑排序
 * 总的来说，就是节点之间有前后依赖，通过拓扑排序能够获取访问的次序,如果 A 依赖于B 则，A的次序排在B前
 *
 * 主要思想是节点的后序遍历，当一个 A -> B,A ->C, C->D ，从 A 出发，访问完B后，需要跳转到最近的一个有子节点的节点，
 * 这里便是A，退栈到A，此时可以访问C ，在后序访问完节点后，将访问过的节点加入访问列别，此时 B D C A 的倒序正是拓扑排序
 *
 * 如例题：https://leetcode.com/problems/course-schedule/
 * @see com.leetcode.CourseSchedule[use dfs]
 *
 *
 *
 *
 *
 * @author wezhyn
 * @since 06.18.2020
 *
 */

class TopologicalSort<T>(private val graph: Graph<T>) where T : Comparable<T> {


    private val order = Stack<Int>()
    private val marked = BooleanArray(graph.v().size) { false }


    fun order(): Iterable<Int> = order.asReversed()

    init {
        for (i in graph.v()) {
            if (!marked[i]) {
                dfs(graph, i)
            }
        }
    }

    private fun dfs(graph: Graph<T>, v: Int) {
        marked[v] = true
        for (e in graph.adjacency(v)) {
            val w = e.to
            if (!marked[w]) {
                dfs(graph, w)
            }
        }
        order.push(v)
    }

}