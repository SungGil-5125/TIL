class Solution {
    fun largestGoodInteger(num: String): String {
        var largest: Int? = null

        for (i in 1..num.length - 2) {
            val prev = num[i - 1].digitToInt()
            val current = num[i].digitToInt()
            val next = num[i + 1].digitToInt()

            if (prev == current && current == next) {
                largest?.let {
                    if (it < current) largest = current
                } ?: run {
                    largest = current
                }
            }
        }

        return if (largest == null) "" else "$largest$largest$largest"
    }
}
