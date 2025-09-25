class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        var result = 0
        val set = nums.toSet()

        for (num in set) {
            if (num - 1 !in set) {
                var current = 1
                while (num + current in set) {
                    current++
                }
                result = maxOf(result, current)
            }
        }

        return result
    }
}
