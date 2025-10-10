class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()

        fun backtrack(start: Int) {
            result.add(ArrayList(current))

            for (i in start until nums.size) {
                current.add(nums[i])
                backtrack(i + 1)
                // 백트래킹으로 구하지 못한 값을 구하기 위해 상위 노드로 이동
                current.removeAt(current.size - 1)
            }
        }

        backtrack(0)
        return result
    }
}

/**
 * 백트래킹을 사용하지 않고 단순 반복문으로 구현한 코드
 *
 * 시간 복잡도는 동일하지만 공간복잡도는 반복문 O(2^n) 이 백트래킹 O(n) 보다 성능이 떨어짐
 */
class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        result.add(emptyList())

        for (num in nums) {
            val current = mutableListOf<List<Int>>()

            for (subset in result) { // 매 단계마다 현재 num 을 리스트에 추가함
                current.add(subset + num)
            }

            result.addAll(current)
        }

        return result
    }
}
