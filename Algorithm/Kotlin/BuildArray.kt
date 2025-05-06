// https://leetcode.com/problems/build-array-from-permutation/description/?envType=daily-question&envId=2025-05-06
class Solution {
    fun buildArray(nums: IntArray): IntArray {
        val map = HashMap<Int, Int>()
        val results: MutableList<Int> = mutableListOf()
        nums.forEachIndexed { index, i ->
            map[index] = i
        }

        nums.map { num ->
            results.add(map.getOrDefault(num, 0))
        }

        return results.toIntArray()
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * 불필요한 HashMap, MutableList 를 사용하지 않음으로서 더 적은 연산과 오버헤드를 줄인다.
 */
class Solution {
    fun buildArray(nums: IntArray): IntArray {
        val ans = IntArray(nums.size)
        for (i in nums.indices) { // nums.indices == (nums.size - 1) == (i in 0 until nums.size)
            ans[i] = nums[nums[i]]
        }
        return ans
    }
}
