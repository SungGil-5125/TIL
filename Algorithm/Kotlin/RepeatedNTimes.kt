class Solution {
    fun repeatedNTimes(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        for (num in nums) {
            if (!set.add(num)) {
                return num
            }
        }
        return 0
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * HashSet 을 사용하지 않으므로 공간 복잡도가 O(N) 에서 O(1) 로 감소
 */
class Solution {
    fun repeatedNTimes(nums: IntArray): Int {
        for (i in 2 until nums.size) {
            val current = nums[i]
            val previous = nums[i - 1]
            val previousPrevious = nums[i - 2]
            if (current == previous || current == previousPrevious) {
                return current
            }
        }
        return nums[0]
    }
}
