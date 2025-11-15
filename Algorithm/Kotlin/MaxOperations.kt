class Solution {
    fun maxOperations(s: String): Int {
        var result = 0
        val s1 = s.toCharArray()
        val length = s.length

        while (String(s1).contains("10")) {
            for (i in 0 until length - 1) {
                if (s1[i] == '1' && s1[i + 1] == '0') {
                    var finished = false
                    var right = i + 1
                    while (!finished) {
                        if (right == length || s1[right] == '1') {
                            s1[right - 1] = '1'
                            s1[i] = '0'
                            finished = true
                            result++
                        } else {
                            right++
                        }
                    }
                }
            }
        }

        return result
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * s[i] 가 1인 카운트 만큼 결과값을 1증가시키니 아래 처럼 간단한 풀이로 수정
 * 시간 복잡도도 O(n)으로 개선
 */
class Solution {
    fun maxOperations(s: String): Int {
        var result = 0
        var ones = 0

        for (i in s.indices) {
            if (s[i] == '1') {
                ones++
            } else if (i > 0 && s[i] == '0' && s[i - 1] == '1') {
                result += ones
            }
        }

        return result
    }
}
