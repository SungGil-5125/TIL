class Solution {
    fun maxSum(nums: IntArray): Int {
        var result = 0
        val seen = mutableSetOf<Int>()

        for (i in nums.indices) {
            val current = nums[i]
            if (current <= 0) continue
            if (current !in seen) {
                seen.add(current)
                result += current
            }
        }

        return result
    }
}
