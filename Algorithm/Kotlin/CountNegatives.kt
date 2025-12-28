class Solution {
    fun countNegatives(grid: Array<IntArray>): Int {
        var result = 0
        val m = grid.size
        val n = grid[0].size

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] < 0) result++
            }
        }

        return result
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * 시간복잡도 O(n + m) 으로 풀기 위해 계산식 탐색법을 사용
 */
class Solution {
    fun countNegatives(grid: Array<IntArray>): Int {
        var result = 0
        val m = grid.size
        val n = grid[0].size

        var r = m - 1 // 가장 마지막 열부터 확인
        var c = 0 // 0번째 인덱스부터 확인

        while (r >= 0 && c < n) {
            if (grid[r][c] < 0) {
                result += (n - c) // 오름차순으로 정렬 되어있기 때문에 음수가 나오는 순간 모두 음수
                r-- // 계단식으로 검색하기 위해 마지막 열까지 검색
            } else {
                c++ // 음수가 아닌경우 음수를 찾기 위해 인덱스 증가
            }
        }

        return result
    }
}
