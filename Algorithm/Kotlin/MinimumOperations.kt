class Solution {
    fun minimumOperations(nums: IntArray): Int {
        var result = 0
        for (num in nums) {
            if (num % 3 != 0) result++
        }
        return result
    }
}
