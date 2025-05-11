class Solution {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        for (i in 0 .. arr.size - 3) {
            val num1 = arr[i]
            val num2 = arr[i + 1]
            val num3 = arr[i + 2]
            if ((isOddNumber(num1) && isOddNumber(num2) && isOddNumber(num3))) return true
        }

        return false
    }

    private fun isOddNumber(num: Int): Boolean {
        return num % 2 == 1
    }
}
