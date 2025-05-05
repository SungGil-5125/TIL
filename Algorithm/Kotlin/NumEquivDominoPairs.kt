// https://leetcode.com/problems/number-of-equivalent-domino-pairs/?envType=daily-question&envId=2025-05-05
class Solution {
    fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
        val map = HashMap<Pair<Int, Int>, Int>()
        var result = 0
        for (domino in dominoes) {
            val pair = if (domino[0] < domino[1]) {
                Pair(domino[0], domino[1])
            } else {
                Pair(domino[1], domino[0])
            }

            val count = map.getOrDefault(pair, 0)
            result += count

            map[pair] = count + 1
        }

        return result
    }
}
