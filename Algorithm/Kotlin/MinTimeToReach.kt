class Solution {
    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        var result = Int.MAX_VALUE
        val n = moveTime.size
        val m = moveTime.first().size

        val directions = listOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0),
        )

        val queue: Queue<IntArray> = LinkedList()
        queue.offer(intArrayOf(0, 0, 0, 1))

        val visited = Array(n) { Array(m) { Int.MAX_VALUE } }
        visited[0][0] = 0

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            val row = current[0]
            val col = current[1]
            val time = current[2]
            val nextMove = current[3]

            if (row == n - 1 && col == m - 1) { // 마지막 방인지 확인
                result = minOf(result, time)
                continue
            }

            if (time > visited[row][col]) continue

            directions.forEach { dir ->
                val newRow = row + dir[0]
                val newCol = col + dir[1]

                if (newRow in 0 until n && newCol in 0 until m) {
                    var newTime = time + nextMove
                    if (time <= moveTime[newRow][newCol]) { // time 과 nextMove 를 더하기 전의 time 으로 계산
                        newTime = moveTime[newRow][newCol] + nextMove
                    }
                    val newNextMove = if (nextMove == 1) 2 else 1

                    if (newTime < visited[newRow][newCol]) {
                        visited[newRow][newCol] = newTime
                        queue.offer(intArrayOf(newRow, newCol, newTime, newNextMove))
                    }
                }
            }
        }

        return result
    }
}
