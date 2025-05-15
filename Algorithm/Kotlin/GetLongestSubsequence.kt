class Solution {
    fun getLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
        val length = words.size
        if (length == 0) return emptyList()
        val result: MutableList<String> = mutableListOf()
        result.add(words[0])
        for (i in 0 until length - 1) {
            if (groups[i] != groups[i + 1]) {
                result.add(words[i + 1])
            }
        }
        return result
    }
}
