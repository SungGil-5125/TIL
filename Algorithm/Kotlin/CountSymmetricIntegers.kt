class Solution {
    fun countSymmetricIntegers(low: Int, high: Int): Int {
        var result = 0
        for (num in low..high) {
            val numStr = num.toString()
            val length = numStr.length
            if (length % 2 != 0) continue

            var first = 0
            var second = 0


            val firstLength = length / 2

            for (j in 0 until firstLength) {
                first += numStr[j].digitToInt()
            }

            for (j in firstLength until length) {
                second += numStr[j].digitToInt()
            }

            if (first == second) result++
        }

        return result
    }
}
