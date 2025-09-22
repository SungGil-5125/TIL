class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var max = nums.first()
        var result = nums.first()

        for (i in 1 until nums.size) {
            max = maxOf(nums[i], max + nums[i])
            result = maxOf(result, max)
        }

        return result
    }
}
