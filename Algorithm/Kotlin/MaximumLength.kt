class Solution {
    fun maximumLength(nums: IntArray, k: Int): Int {
        var maxLength = 0
        val n = nums.size

        for (targetRemainder in 0 until k) {
            val dp = IntArray(n) { 1 }

            for (i in 1 until n) {
                for (j in 0 until i) {
                    if ((nums[j] + nums[i]) % k == targetRemainder) {
                        dp[i] = maxOf(dp[i], dp[j] + 1)
                    }
                }
                maxLength = maxOf(maxLength, dp[i])
            }
        }

        return maxLength
    }
}
