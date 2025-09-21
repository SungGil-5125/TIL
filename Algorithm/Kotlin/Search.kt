class Solution {
    fun search(nums: IntArray, target: Int): Int {
        for (i in nums.indices) {
            if (nums[i] == target) return i
        }

        return -1
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * 배열을 중간으로 나눠서 배열을 모두 순회하는 o(n) 의 시간 복잡도를 o(log n) 으로 줄임
 */
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var right = nums.size - 1
        var left = 0

        while (left <= right) {
            val m = (left + right) / 2
            if (nums[m] == target) return m
            if (nums[m] < target) {
                left = m + 1
            } else {
                right = m - 1
            }
        }

        return -1
    }
}
