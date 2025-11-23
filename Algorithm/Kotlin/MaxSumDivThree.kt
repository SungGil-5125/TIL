class Solution {
    fun maxSumDivThree(nums: IntArray): Int {
        val dp = intArrayOf(0, Int.MIN_VALUE, Int.MIN_VALUE)

        for (num in nums) {
            val temp = dp.clone()
            for (i in 0..2) {
                // 나머지 1, 2일때도 더해서 나머지 0을 만들 수 있기 때문에 계산해둠
                val remainder = (i + num) % 3
                dp[remainder] = maxOf(dp[remainder], temp[i] + num)
            }
        }

        return dp[0]
    }
}
