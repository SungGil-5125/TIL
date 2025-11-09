class Solution {
    fun countOperations(num1: Int, num2: Int): Int {
        var n1 = num1
        var n2 = num2
        var result = 0

        while (n1 != 0 && n2 != 0) {
            if (n1 >= n2) {
                n1 -= n2
            } else {
                n2 -= n1
            }
            result++
        }

        return result
    }
}
