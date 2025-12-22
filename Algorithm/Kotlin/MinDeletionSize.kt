class Solution {
    fun minDeletionSize(strs: Array<String>): Int {
        var result = 0

        val n = strs.size
        val m = strs[0].length

        for (i in 0 until m) {
            var temp = ""

            for (j in 0 until n) {
                temp += strs[j][i]
            }

            val sorted = temp.toCharArray().sorted().joinToString("")
            if (temp != sorted) result++
        }

        return result
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * 정렬된 요소인지 확인하기 위해 배열을 만들고 정렬하지 않도록 해
 * 시간 복잡도와 공간 복잡도 개선
 */
class Solution {
    fun minDeletionSize(strs: Array<String>): Int {
        var result = 0
        val n = strs.size
        val m = strs[0].length

        for (col in 0 until m) {
            for (row in 1 until n) {
                if (strs[row][col] < strs[row - 1][col]) {
                    result++
                    break
                }
            }
        }

        return result
    }
}
