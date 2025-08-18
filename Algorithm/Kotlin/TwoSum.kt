class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            val first = nums[i]
            for (j in i + 1 until nums.size) {
                val second = nums[j]

                if (first + second == target) {
                    return intArrayOf(i, j)
                }
            }
        }

        return intArrayOf()
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * 불필요한 반복문을 줄임으로서 시간 복잡도를 개선한 코드
 */
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numMap = mutableMapOf<Int, Int>()

        for ((index, num) in nums.withIndex()) {
            val complement = target - num
            numMap[complement]?.let {
                return intArrayOf(it, index)
            }
            numMap[num] = index
        }

        return intArrayOf()
    }
}
