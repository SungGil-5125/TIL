class Solution {
    fun totalMoney(n: Int): Int {
        var total = 0
        var previousMoney = 1
        var increaseMoney = 0

        for (i in 0 until n) {
            if (i != 0 && i % 7 == 0) {
                previousMoney++
                increaseMoney = previousMoney
                total += previousMoney
            } else {
                increaseMoney++
                total += increaseMoney
            }
        }

        return total
    }
}
