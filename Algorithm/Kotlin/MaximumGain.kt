class Solution {
    fun maximumGain(s: String, x: Int, y: Int): Int {
        val (max, min) = if (x > y) Pair("ab", x) to Pair("ba", y) else Pair("ba", y) to Pair("ab", x)
        val (remainder, score1) = remove(s, max.first, max.second)
        val (_, score2) = remove(remainder, min.first, min.second)
        return score1 + score2
    }

    private fun remove(s: String, pattern: String, score: Int): Pair<String, Int> {
        val sb = StringBuilder()
        var total = 0

        for (char in s) {
            if (sb.isEmpty()) {
                sb.append(char)
                continue
            }

            val prev = sb[sb.length - 1].toString()
            val current = char.toString()
            if (prev + current == pattern) {
                total += score
                sb.deleteAt(sb.length - 1)
            } else {
                sb.append(current)
            }
        }

        return Pair(sb.toString(), total)
    }
}
