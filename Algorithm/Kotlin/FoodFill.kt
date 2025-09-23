private val directions = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val target = image[sr][sc]

        // 이미 같은 색상일때 시도하면 항상 current == target 이기 때문에 StackOverflowError 발생
        if (target != color) {
            dfs(image, sr, sc, color, target)
        }

        return image
    }

    private fun dfs(
        image: Array<IntArray>,
        row: Int,
        col: Int,
        color: Int,
        target: Int,
    ) {
        // 값을 구할 수 없는 범위를 벗어난 row 와 col 은 구할 수 없기 때문에 검사 로직 추가
        if (row >= 0 && row < image.size && col >= 0 && col < image[0].size) {
            val current = image[row][col]
            if (current == target) { // 처음 시작한 값과 현재 위치에 있는 값이 일치할때만 바꾸도록 함
                image[row][col] = color
                for ((dr, dc) in directions) { // directions 을 통해서 위, 아래, 왼쪽, 오른쪽을 계속 돌면서 재귀를 돌도록 함
                    dfs(image, row + dr, col + dc, color, target)
                }
            }
        }
    }
}
