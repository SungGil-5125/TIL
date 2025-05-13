class Solution {
    fun lengthAfterTransformations(s: String, t: Int): Int {
        if (t == 0) return s.length

        val mod = 1_000_000_007
        var counts = LongArray(26)
        for (c in s) { // ex) b - a
            counts[c - 'a']++
        }

        repeat(t) {
            val temp = LongArray(26)
            for (i in 0 until 26) {
                if (i == 25) { // 'z'는 "ab"로 변환
                    temp[0] = (temp[0] + counts[i]) % mod
                    temp[1] = (temp[1] + counts[i]) % mod
                } else {
                    // 다른 문자는 다음 알파벳으로 변환
                    temp[i + 1] = (temp[i + 1] + counts[i]) % mod
                }
            }

            counts = temp
        }

        var result = 0L
        for (count in counts) {
            result = (result + count) % mod
        }
        return result.toInt()
    }
}
