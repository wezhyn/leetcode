package com.leetcode

/**
 * 给定一组有向边，检查是否含有环
 *
 * Example 1：
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * @author wezhyn
 * @since 06.20.2020
 *
 */
class CourseSchedule {
    /**
     * -1 未访问；0：正在访问；1：结束
     */
    private lateinit var visited: IntArray
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        visited = IntArray(numCourses) { -1 }
        val map = HashMap<Int, MutableList<Pair<Int, Int>>>()
        prerequisites.forEach {
            val u = it[0]
            val v = it[1]
//            u dependency v
            val dependencies = map.getOrPut(u) { ArrayList<Pair<Int, Int>>() }
            dependencies.add(Pair(u, v))
        }

        for ((i, v) in visited.withIndex()) {
            if (v == -1) {
                if (dfs(map, i)) {
                    return false
                }
            }
        }
        return true
    }

    private fun dfs(map: Map<Int, List<Pair<Int, Int>>>, v: Int): Boolean {
        try {
            val dependencies = map[v] ?: return false
            var result = false
            for (pair in dependencies) {
                when (visited[pair.second]) {
                    1 -> result = result || false
                    0 -> return true
                    -1 -> {
                        visited[v] = 0
                        result = result || dfs(map, pair.second)
                    }
                }
            }
            return result
        } finally {
            visited[v] = 1
        }
    }
}