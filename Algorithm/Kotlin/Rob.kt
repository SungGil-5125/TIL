class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        val n = nums.size
        val dp = IntArray(n)

        dp[0] = nums[0]
        dp[1] = maxOf(nums[1], dp[0])

        // i 번째 집을 턴다? i 번째 집을 안턴다?
        for (i in 2 until n) {
            val target = nums[i]
            dp[i] = maxOf(dp[i - 2] + target, dp[i - 1])
        }

        return dp[n - 1]
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * 같은 타뷸레이션(Bottom Up) 방식이지만 DP 배열을 사용하지 않아 공간복잡도가
 * O(N) 에서 O(1) 로 공간복잡도를 최적화 함
 */
class Solution {
    fun rob(nums: IntArray): Int {
        var prev = 0
        var current = 0

        for (num in nums) {
            val max = maxOf(current, prev + num) // maxOf(dp[i - 1], dp[i - 2] + nums[i]) 와 같음
            prev = current // 값이 커지기 전에 최대값을 기록해둠. 그럼으로써 이전 값을 기록해두니 인접한 값이 아님
            current = max
        }

        return current
    }
}
