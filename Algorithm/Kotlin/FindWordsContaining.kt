class Solution {
    fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
        val n = words.size
        val result: MutableList<Int> = mutableListOf()

        for (i in 0 until n) {
            if (words[i].any { it == x }) result.add(i)
        }

        return result
    }
}
