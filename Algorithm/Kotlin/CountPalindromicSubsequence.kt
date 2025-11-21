class Solution {
    fun countPalindromicSubsequence(s: String): Int {
        var result = 0
        val uniqueChars = s.toSet()

        // 각 고유 문자를 양 끝 문자로 사용
        for (char in uniqueChars) {
            val firstIndex = s.indexOf(char)
            val lastIndex = s.lastIndexOf(char)

            // 회문을 만들 수 있는지 중간에 문자가 있는지 확인
            if (lastIndex - firstIndex > 1) {
                val middleChars = s.substring(firstIndex + 1, lastIndex).toSet()

                result += middleChars.size
            }
        }

        return result
    }
}
