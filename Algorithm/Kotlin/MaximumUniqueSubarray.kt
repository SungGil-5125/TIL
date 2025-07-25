class Solution {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        val seen = mutableSetOf<Int>()
        var left = 0
        var sum = 0
        var result = 0

        for (right in nums.indices) {
            while (nums[right] in seen) {
                seen.remove(nums[left])
                sum -= nums[left]
                left++
            }
            seen.add(nums[right])
            sum += nums[right]
            result = maxOf(result, sum)
        }
        return result
    }
}
