class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var left = 0
        var zeros = 0
        var maxLength = 0

        for (right in nums.indices) {
            if (nums[right] == 0) zeros += 1

            while (zeros > 1) {
                if (nums[left] == 0) zeros -= 1
                left += 1
            }

            maxLength = maxOf(maxLength, right - left)
        }

        return maxLength
    }
}
