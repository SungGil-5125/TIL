class Solution {
    fun hasSameDigits(s: String): Boolean {
        if (s.length < 2) return false

        var str = s
        while (str.length > 2) {
            val temp = mutableListOf<Int>()

            for(i in 0 until str.length - 1) {
                val current = str[i].digitToInt()
                val next = str[i + 1].digitToInt()
                val digit = (current + next) % 10
                temp.add(digit)
            }

            if (temp.isNotEmpty()) {
                str = ""
                for (i in temp.indices) {
                    str += temp[i]
                }
            }
        }

        return str[0] == str[1]
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * mutableListOf() 대신 StringBuilder 사용으로 메모리 최적화
 */
class Solution {
    fun hasSameDigits(s: String): Boolean {
        if (s.length < 2) return false

        var str = s
        while (str.length > 2) {
            val sb = StringBuilder()
            for (i in 0 until str.length - 1) {
                val digit = (str[i].digitToInt() + str[i + 1].digitToInt()) % 10
                sb.append(digit)
            }
            str = sb.toString()
        }

        return str[0] == str[1]
    }
}
