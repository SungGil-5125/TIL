class Solution {
    fun minimumBoxes(apple: IntArray, capacity: IntArray): Int {
        var result = 0
        var remain = 0
        val sum = apple.sum()

        val sorted = capacity.sorted()

        val m = sorted.size - 1

        for (i in m downTo 0) {
            if (i == m) {
                remain = sum - sorted[i]
            } else {
                remain -= sorted[i]
            }

            if (remain > 0) {
                result++
            } else {
                result++
                return result
            }
        }

        return result
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * 정렬한 배열을 메모리에 두지 않아서 공간 복잡도 감소
 * 불필요한 if 문을 감소
 */
class Solution {
    fun minimumBoxes(apple: IntArray, capacity: IntArray): Int {
        var result = 0
        var remain = apple.sum()

        capacity.sortDescending()

        for (box in capacity) {
            remain -= box
            result ++
            if (remain <= 0) break
        }

        return result
    }
}
