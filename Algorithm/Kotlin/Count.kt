class Solution {
    fun countHillValley(nums: IntArray): Int {
        var result = 0

        for (i in 1..<nums.size - 1) {
            var prev: Int? = null
            var next: Int? = null
            val current = nums[i]

            if (i > 1 && nums[i-1] == current) continue

            for (j in i - 1 downTo 0) {
                if (nums[j] != current) {
                    prev = nums[j]
                    break
                }
            }

            for (j in i + 1 until nums.size) {
                if (nums[j] != current) {
                    next = nums[j]
                    break
                }
            }

            if (prev == null || next == null) continue

            if (current < next && current < prev) {
                result++
                continue
            }
            if (current > next && current > prev) {
                result++
                continue
            }
        }

        return result
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * 전 풀이의 경우 시간 복잡도가 최악의 경우 O(n²) 가 될 수 있는데 O(n) 의 시간복잡도를 가지도록 개선
 */
class Solution {
    fun countHillValley(nums: IntArray): Int {
        if (nums.size <= 2) return 0
        var result = 0

        var prev = nums[0]
        var current = nums[1]
        var next: Int

        for (i in 2..<nums.size) {
            if (current == prev) {
                current = nums[i]
                continue
            }

            next = nums[i]

            if (next != current) {
                if (current < next && current < prev) result++
                if (current > next && current > prev) result++
                prev = current
                current = next
            }
        }

        return result
    }
}
