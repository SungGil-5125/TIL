class Solution {
    fun numSubmat(mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size
        var result = 0

        // 각 행에서 왼쪽으로 연속된 1의 개수를 저장
        val width = Array(m) { IntArray(n) }

        // width 배열 계산
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (mat[i][j] == 1) {
                    width[i][j] = if (j == 0) 1 else width[i][j-1] + 1
                } else {
                    width[i][j] = 0
                }
            }
        }

        // 각 위치를 오른쪽 아래 모서리로 하는 직사각형 개수 계산
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (mat[i][j] == 1) {
                    var minWidth = width[i][j]

                    // 현재 위치에서 위로 올라가면서 직사각형 개수 계산
                    for (k in i downTo 0) {
                        minWidth = minOf(minWidth, width[k][j])
                        result += minWidth
                    }
                }
            }
        }

        return result
    }
}
