class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val firstMap: MutableMap<Char, Int> = mutableMapOf()
        val secondMap: MutableMap<Char, Int> = mutableMapOf()

        for (char in s) {
            val count = firstMap.getOrDefault(char, 0)
            firstMap[char] = (count + 1)
        }

        for (char in t) {
            val count = secondMap.getOrDefault(char, 0)
            secondMap[char] = (count + 1)
        }

        for (char in t) {
            val sCount = firstMap[char]
            val tCount = secondMap[char]
            if (sCount != tCount) return false
        }

        return true
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * s 와 t 의 char 의 개수가 서로 다른지를 비교하는 반복문을 하나로 합쳐서 시간 복잡도를 줄임
 */
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val arr = IntArray(26)
        for (i in s.indices) {
            arr[s[i] - 'a']++
            arr[t[i] - 'a']--
        }
        return arr.all { it == 0 }
    }
}
