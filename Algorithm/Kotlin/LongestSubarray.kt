class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var result = 1
        val temp = mutableListOf<Int>()
        val max = nums.max()

        for (i in 1 until nums.size) {
            val prev = nums[i - 1]
            val current = nums[i]

            if (prev == current && current == max) {
                ++result
            }
            if (prev != current && current == max) {
                temp.add(result)
                result = 1
            }
        }

        return if (temp.isEmpty()) result else maxOf(result, temp.max())
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * 전 풀이 보다 불필요한 리스트와 가장 큰 값을 구하는 연산을 삭제하여
 * 공간 복잡도와 시간 복잡도를 개선한 코드
 */
class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var max = 0
        var result = 0
        var temp = 0

        for (num in nums) {
            if (num > max) {
                result = 0
                max = num
                temp = 0
            }

            if (max == num) {
                temp += 1
            } else {
                temp = 0
            }

            result = maxOf(result, temp)
        }

        return result
    }
}
