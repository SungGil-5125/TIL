class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val n = nums.size
        val dp = IntArray(n) { 1 } // 본인도 카운트 횟수로 치기 때문에 1로 초기화
        var result = 1

        for (i in 1 until n) {
            for (j in i - 1 downTo 0) { // 최적해를 구하기 위해서 0번 인덱스까지 다시 탐색
                if (nums[j] < nums[i]) { // j 가 더 작아야 함
                    dp[i] = maxOf(dp[i], dp[j] + 1) // 0번 인덱스까지 가면서 가장 큰 수를 기록
                    result = maxOf(result, dp[i])
                }
            }
        }

        return result
    }
}
