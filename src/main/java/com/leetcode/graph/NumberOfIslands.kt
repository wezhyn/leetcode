package com.leetcode.graph

/**
 *
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 * 使用 dfs 将岛屿变成 0
 * @author wezhyn
 * @since 06.19.2020
 *
 */
class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        var num = 0
        for ((r, row) in grid.withIndex()) {
            for (l in row.indices) {
                if (row[l] == '1') {
                    num++
                    dfs(grid, r, l)
                }
            }
        }
        return num
    }

    private fun dfs(grid: Array<CharArray>, r: Int, l: Int) {
        if (r >= grid.size || l >= grid[0].size
                || r < 0 || l < 0
                || grid[r][l] == '0') {
            return
        }
        grid[r][l] = '0'
        dfs(grid, r, l - 1)
        dfs(grid, r, l + 1)
        dfs(grid, r + 1, l)
        dfs(grid, r - 1, l)
    }
}