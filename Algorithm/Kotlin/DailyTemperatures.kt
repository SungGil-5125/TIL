class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val size = temperatures.size
        val answer = IntArray(size) { 0 }

        for (i in 0 until size) {
            val current = temperatures[i]

            for (j in (i + 1) until size) {
                val next = temperatures[j]
                if (current < next) {
                    answer[i] = (j - i)
                    break
                }
            }
        }

        return answer
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * 기존 풀이는 완전 탐색 알고리즘으로 시간 복잡도가 O(n²) 이지만,
 * 단조 스택 알고리즘을 사용하여 시간 복잡도를 O(n) 으로 감소 시킴
 * 천재적인 알고리즘이다..
 */
class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)
        val stack = mutableListOf<Int>()

        for (i in temperatures.indices) {
            // 현재 온도가 더 높으면 스택에서 답 찾기
            while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.last()]) {
                val prevIndex = stack.removeLast()
                result[prevIndex] = i - prevIndex
            }

            stack.add(i)
        }

        return result
    }
}
