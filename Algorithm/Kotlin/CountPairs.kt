class Solution {
    fun countPairs(nums: IntArray, k: Int): Int {
        var result = 0
        val n = nums.size
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    result++
                }
            }
        }
        return result
    }
}
