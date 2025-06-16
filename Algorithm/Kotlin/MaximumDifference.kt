class Solution {
    fun maximumDifference(nums: IntArray): Int {
        var max = -1
        for (i in 0..nums.size) {
            for (j in i + 1..<nums.size) {
                if (nums[i] < nums[j]) {
                    val temp = nums[j] - nums[i]
                    if (temp > max) max = temp
                }
            }
        }

        return max
    }
}