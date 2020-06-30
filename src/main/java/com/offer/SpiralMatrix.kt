package com.offer

/**
 *
 *  简单的循环打印数组
 * @author wezhyn
 * @since 06.30.2020
 *
 */
class SpiralMatrix {

    companion object {
        val offset = intArrayOf(1, 1, -1, -1, 0)
    }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
//        每一条边打印 m-1 | n -1
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return emptyList()
        }
        val m = matrix.size
        val n = matrix[0].size
//        多余的记录，只需要记录最后一圈
        val visited = Array(matrix.size) { IntArray(matrix[it].size) }
        val result = ArrayList<Int>()
        val v = { x: Int, y: Int ->
            if (visited[x][y] == 0) {
                result.add(matrix[x][y])
                visited[x][y] = 1
            }
        }
        for (loop in 1..(Math.min(m, n) + 1).shr(1)) {
//            0,0,1,1
            var x = loop - 1
            var y = x
            for (i in 0..3) {
//                当前横向纵向的最大长度，
                val maxLen = (if (i.and(1) == 0) n else m) - (loop - 1) * 2 - 1
//                等于0时，尝试打印当前位置
                if (maxLen == 0) {
                    v(x, y)
                } else {
                    for (step in 1..maxLen) {
                        v(x, y)
                        if (i.and(1) == 0) {
                            y += offset[i]
                        } else {
                            x += offset[i]
                        }
                    }
                }
            }
        }
        return result
    }
}