class Solution {
    fun differenceOfSums(n: Int, m: Int): Int {
        var num1 = 0
        var num2 = 0
        for (i in 1..n) {
            if (i % m == 0) {
                num2 += i
            } else {
                num1 += i
            }
        }

        return num1 - num2
    }
}
