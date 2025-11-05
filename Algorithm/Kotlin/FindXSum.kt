class Solution {
    fun findXSum(nums: IntArray, k: Int, x: Int): IntArray {
        val n = nums.size
        val result = IntArray(n - k + 1)

        var left = 0
        var right = k - 1

        for (i in result.indices) {
            val map = hashMapOf<Int, Int>()
            for (j in left .. right) {
                val count = map.getOrDefault(nums[j], 0)
                map[nums[j]] = count + 1
            }

            val entries = map.entries
            val sorted = entries
                .sortedWith(compareByDescending<Map.Entry<Int, Int>> { it.value }
                    .thenByDescending { it.key })

            val limit = minOf(x, sorted.size)

            var sum = 0
            for (z in 0 until limit) {
                sum += (sorted[z].key * sorted[z].value)
            }

            left++
            right++
            result[i] = sum
        }

        return result
    }
}
