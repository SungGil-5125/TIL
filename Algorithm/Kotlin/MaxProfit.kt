class Solution {
    fun maxProfit(prices: IntArray): Int {
        var result = 0
        var min = prices[0]

        for (price in prices) {
            if (min > price) {
                min = price
            }

            val profit = price - min
            if (profit > result) result = profit
        }

        return result
    }
}
