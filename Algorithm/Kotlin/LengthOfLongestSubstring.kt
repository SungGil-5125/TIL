class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        var left = 0
        var right = 0
        val set: HashSet<Char> = hashSetOf()

        while (right < s.length) {
            if (!set.contains(s[right])) {
                set.add(s[right])
                right++
                max = maxOf(max, set.size)
            } else {
                set.remove(s[left])
                left++
            }
        }

        return max
    }
}
