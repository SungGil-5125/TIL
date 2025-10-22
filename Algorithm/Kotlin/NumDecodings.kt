class Solution {
    fun numDecodings(s: String): Int {
        if (s.isEmpty() || s[0] == '0') return 0

        val n = s.length
        // 타뷸레이션 기법을 사용해서 피보나치 수열과 같은 점화식 사용
        val dp = IntArray(n + 1)

        dp[0] = 1
        dp[1] = 1

        for (i in 2 .. n) {
            // 한자리 숫자로 해석하여 카운트 추가
            if (s[i - 1] != '0') {
                dp[i] += dp[i - 1]
            }

            // 두자리 숫자로 해석하여 카운트 추가
            val twoDigit = s.substring(i - 2, i).toInt()
            if (twoDigit in 10..26) {
                dp[i] += dp[i - 2]
            }
        }

        return dp[n]
    }
}
