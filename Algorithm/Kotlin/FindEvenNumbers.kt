class Solution {
    fun findEvenNumbers(digits: IntArray): IntArray {
        val allNums = sortedSetOf<Int>()
        for (i in digits.indices) {
            if (digits[i] == 0) continue
            for (j in digits.indices) {
                if (i == j) continue
                for (k in digits.indices) {
                    if (i == k || j == k) continue
                    if (digits[k] % 2 == 1) continue
                    val num = digits[i] * 100 + digits[j] * 10 + digits[k]
                    allNums.add(num)
                }
            }
        }

        return allNums.toIntArray()
    }
}
