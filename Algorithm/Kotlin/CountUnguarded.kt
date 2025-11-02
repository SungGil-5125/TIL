class Solution {
    /**
     * 경비 1
     * 벽 2
     * 경비 구역 3
     * 아무곳도 아닌곳 0
     */
    fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
        var result = 0
        val grid = Array(m) { IntArray(n) }

        for (guard in guards) {
            val row = guard[0]
            val col = guard[1]
            grid[row][col] = 1
        }

        for (wall in walls) {
            val row = wall[0]
            val col = wall[1]
            grid[row][col] = 2
        }

        fun isValid(row: Int, col: Int) = grid[row][col] != 1 && grid[row][col] != 2

        for (guard in guards) {
            val row = guard[0]
            val col = guard[1]

            for (i in col + 1 until n) {
                if (!isValid(row, i)) break
                grid[row][i] = 3
            }

            for (i in col - 1 downTo 0) {
                if (!isValid(row, i)) break
                grid[row][i] = 3
            }

            for (i in row + 1 until m) {
                if (!isValid(i, col)) break
                grid[i][col] = 3
            }

            for (i in row - 1 downTo 0) {
                if (!isValid(i, col)) break
                grid[i][col] = 3
            }
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 0) result++
            }
        }

        return result
    }
}
