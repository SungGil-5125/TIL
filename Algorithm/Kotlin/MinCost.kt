class Solution {
    fun minCost(colors: String, neededTime: IntArray): Int {
        val n = colors.length
        var result = 0

        val list = mutableListOf<Int>()
        for (i in 1 until n) {
            // 다음 요소가 다를때 list 가 비어있는지 확인하고 가장 큰값 빼고 다 더하고 result 에 넣기
            val prev = colors[i - 1]
            val current = colors[i]
            if (prev == current) {
                if (list.isEmpty()) {
                    list.add(neededTime[i - 1])
                }
                list.add(neededTime[i])
            } else {
                if (list.isNotEmpty()) {
                    list.remove(list.max())
                    result += list.sum()
                    list.clear()
                }
            }
        }

        if (list.isNotEmpty()) {
            list.remove(list.max())
            result += list.sum()
            list.clear()
        }

        return result
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * list.max() 와 list.remove() 는 각각 시간복잡도가 O(n) 이기 때문에 리스트를 삭제한 풀이
 */
class Solution {
    fun minCost(colors: String, neededTime: IntArray): Int {
        var result = 0
        var prevMax = neededTime[0]

        for (i in 1 until colors.length) {
            val prev = colors[i - 1]
            val current = colors[i]
            if (prev == current) {
                result += minOf(prevMax, neededTime[i])
                prevMax = maxOf(prevMax, neededTime[i])
            } else {
                prevMax = neededTime[i]
            }
        }

        return result
    }
}
