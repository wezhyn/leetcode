package com.wezhyn.learn.dp

/**
 *
 * @author wezhyn
 * @since 06.24.2020
 *
 */
class UniquePathsII {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val lastRow = obstacleGrid.size - 1
        val dp = Array(obstacleGrid.size) { IntArray(obstacleGrid[it].size) { 0 } }
        if (lastRow < 0) {
            return 0
        } else if (obstacleGrid[0].isEmpty()) {
            return 1
        }
        if (lastRow == 0 && obstacleGrid[0].size == 1) {
            return if (obstacleGrid[0][0] == 1) 0 else 1
        }
        dp[lastRow][obstacleGrid[lastRow].size - 1] = 1
        for (row in lastRow downTo 0) {
            val maxC = obstacleGrid[row].size - 1
            for (column in maxC downTo 0) {
                if (obstacleGrid[row][column] == 0) {
                    dp[row][column] = dp[row][column] + getDp(dp, obstacleGrid, row + 1, column) + getDp(dp, obstacleGrid, row, column + 1)
                }
            }
        }
        return dp[0][0]
    }

    private fun getDp(dp: Array<IntArray>, obstacleGrid: Array<IntArray>, x: Int, y: Int): Int {
        if (x < 0 || x >= dp.size || y < 0 || y >= dp[x].size || obstacleGrid[x][y] == 1) {
            return 0
        }
        return dp[x][y]
    }
}