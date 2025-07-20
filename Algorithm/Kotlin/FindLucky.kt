class Solution {
    fun findLucky(arr: IntArray): Int {
        var result = -1
        val map: HashMap<Int, Int> = HashMap()

        for (a in arr) {
            map[a] = map.getOrDefault(a, 0) + 1
        }

        for (m in map.keys) {
            if (m == map[m] && result < m) {
                result = m
            }
        }

        return result
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * 불필요한 result < m 연산을 삭제하고 제약사항의 가장 큰 값인
 * 500 부터 검사하여 가장 큰 값을 구하도록 함.
 */
class Solution {
    fun findLucky(arr: IntArray): Int {
        val freq = IntArray(501)
        for (num in arr) freq[num]++

        for (i in 500 downTo 1) {
            if (freq[i] == i) return i
        }

        return -1
    }
}
