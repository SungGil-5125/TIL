class Solution {
    fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
        queries.forEach { (l, r) ->
            for (i in l..r) {
                nums[i] -= 1
            }
        }
        return nums.all { it <= 0 }
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * 불 필요한 nums 의 배열 사이즈 만큼 순회하는 연산을 줄임
 */
class Solution {
    fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
        val diff = IntArray(nums.size + 1)

        // 각 위치에서 얼마 만큼의 -1 을 적용할 수 있는 diff 배열 생성
        for (query in queries) {
            diff[query[0]] += 1
            diff[query[1] + 1] += -1
        }

        var sums = 0
        for (i in nums.indices) {
            val num = nums[i]
            // 각 위치에서 누적된 diff[i] 번 -1 할 수 있는지 구하기 위해서 sums 생성
            sums += diff[i]
            if (num - sums > 0) { // 해당 nums 이 누적된 diff[i] 번 -1 해도 0 이 될 수 없으면 false 반환
                return false
            }
        }

        return true
    }
}
