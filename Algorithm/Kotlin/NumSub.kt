class Solution {
    fun numSub(s: String): Int {
        val mod = 1000000007L
        var result = 0L
        var count = 0L

        for (char in s) {
            if (char == '1') {
                count++
                // 새로 만들어지는 부분 문자열 개수를 카운트하여 더하기
                result = (result + count) % mod
            } else {
                count = 0
            }
        }

        return result.toInt()
    }
}
