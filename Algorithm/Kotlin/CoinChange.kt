class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { amount + 1 }

        dp[0] = 0

        for (i in 1..amount) {
            for (coin in coins) {
                if (i >= coin) { // 현재 가격이 구하려는 코인보다 크거나 같을때만 구함
                    dp[i] = minOf(dp[i], dp[i - coin] + 1)
                    // 현재 가격과 현재 코인을 빼서 최소 값을 계산함
                    // bottom-up 방식으로 이미 구해둔 메모리 값으로 최소 값을 계산함
                }
            }
        }

        return if (dp[amount] > amount) -1 else dp[amount]
    }
}
