class Solution {
    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        var result = 0L

        happiness.sortDescending()

        for (i in 0 until k) {
            val max = if ((happiness[i] - i) > 0) {
                happiness[i] - i
            } else 0

            result += max
        }

        return result
    }
}
