class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val n = s.length
        val dp = BooleanArray(n + 1)
        dp[0] = true

        for (i in 1..n) { // dp[0] 은 계산 없이 초기화 했기 때문에 1부터 시작
            for (j in 0 until i) {
                // dp[j] == true 를 확인하는 것은 순차적으로 문자열을 이었는지를 확인하기 위함임
                if (dp[j] && s.substring(j, i) in wordDict) {
                    dp[i] = true
                    break
                }
            }
        }

        return dp[n]
    }
}
