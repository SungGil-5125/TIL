// https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/?envType=daily-question&envId=2025-05-09
class Solution {
    fun countSubarrays(nums: IntArray): Int {
        var count = 0
        for (i in 0..nums.size - 3) {
            val num1 = nums[i]
            val num2 = nums[i + 1]
            val num3 = nums[i + 2]
            if ((num1 + num3).toDouble() == num2.toDouble() / 2.0) {
                count++
            }
        }

        return count
    }
}
