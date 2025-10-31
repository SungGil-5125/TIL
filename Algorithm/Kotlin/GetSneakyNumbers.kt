class Solution {
    fun getSneakyNumbers(nums: IntArray): IntArray {
        val n = nums.size
        val array = IntArray(n)
        val result = mutableListOf<Int>()

        for (num in nums) {
            array[num]++
        }

        for (i in 0 until n - 1) {
            if (array[i] == 2) result.add(i)
            if (result.size == 2) return result.toIntArray()
        }

        return intArrayOf()
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * 시간 복잡도는 동일하지만, 불필요한 반복문을 줄여 효율성 확보
 */
class Solution {
    fun getSneakyNumbers(nums: IntArray): IntArray {
        val n = nums.size
        val exist = BooleanArray(n) { false }
        val results = IntArray(2)
        var count = 0

        for (num in nums) {
            if (!exist[num]) {
                exist[num] = true
            } else {
                results[count++] = num
            }
        }

        return results
    }
}
