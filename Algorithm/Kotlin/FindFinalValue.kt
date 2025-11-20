class Solution {
    fun findFinalValue(nums: IntArray, original: Int): Int {
        var result = original
        var isFinished = false

        while (!isFinished) {
            for (i in nums.indices) {
                if (nums[i] == result) {
                    result *= 2
                    break
                }

                if (nums.lastIndex == i) {
                    isFinished = true
                }
            }
        }

        return result
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * 첫번째 풀이의 경우 result 를 찾을 때마다 배열을 순회함
 * 두번째 풀이의 경우는 hashSet 을 사용했기 때문에 O(1) 의 시간 복잡도로 해결 가능함
 */
class Solution {
    fun findFinalValue(nums: IntArray, original: Int): Int {
        val set = HashSet<Int>()
        for (num in nums) {
            set.add(num)
        }
        var result = original
        while (result in set) {
            result *= 2
        }
        return result
    }
}
