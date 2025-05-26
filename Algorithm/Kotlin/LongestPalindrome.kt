class Solution {
    fun longestPalindrome(words: Array<String>): Int {
        val map = mutableMapOf<String, Int>()
        for (word in words) {
            map[word] = map.getOrDefault(word, 0) + 1
        }

        var result = 0
        var centerUsed = false

        for (word in map.keys) {
            val count = map.getOrDefault(word, 0)
            if (count == 0) continue

            if (word[0] == word[1]) {
                val pairs = count / 2
                result += pairs * 4

                if (count % 2 == 1 && !centerUsed) {
                    result += 2
                    centerUsed = true
                }

                map[word] = 0
            } else {
                val reversed = word.reversed()
                val reversedCount = map.getOrDefault(reversed, 0)
                if (reversedCount > 0) {
                    result += reversedCount * 4
                    map[word] = 0
                    map[reversed] = 0
                }
            }
        }

        return result
    }
}
