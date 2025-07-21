class Solution {
    fun makeFancyString(s: String): String {
        var result = ""
        for (char in s) {
            if (result.length >= 2 &&
                result[result.length - 1] == char &&
                result[result.length - 2] == char) {
                continue
            }
            result += char
        }
        return result
    }
}
