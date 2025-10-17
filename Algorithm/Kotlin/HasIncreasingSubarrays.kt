class Solution {
    fun hasIncreasingSubarrays(nums: List<Int>, k: Int): Boolean {
        var prevLen = 0
        var currLen = 1

        for (i in 1 until nums.size) {
            if (nums[i - 1] < nums[i]) {
                currLen++
            } else {
                prevLen = currLen
                currLen = 1
            }

            // 연속 증가 길이가 반 이상 길면 true
            if (currLen >= 2 * k) return true

            // 인접한 이전 연속 증가 길이와 현재 연속 증가 길이가 k 보다 길면 true
            if (prevLen >= k && currLen >= k) return true
        }

        return false
    }
}
