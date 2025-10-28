class Solution {
    fun countValidSelections(nums: IntArray): Int {
        var result = 0
        val n = nums.size

        for (i in 0 until n) {
            if (nums[i] == 0) {
                if (move(i, true, nums.copyOf())) result++
                if (move(i, false, nums.copyOf())) result++
            }
        }

        return result
    }

    private fun move(index: Int, isLeft: Boolean, nums: IntArray): Boolean {
        var curr = index
        var isLeft = isLeft
        var isRight = !isLeft

        while (0 <= curr && curr <= nums.size - 1) {
            if (nums[curr] == 0) {
                if (isLeft) curr--
                if (isRight) curr++
            } else if (nums[curr] > 0) {
                nums[curr] = nums[curr] - 1
                if (isLeft) {
                    isRight = true
                    isLeft = false
                } else {
                    isLeft = true
                    isRight = false
                }

                if (isLeft) curr--
                if (isRight) curr++
            }
        }

        return nums.all { it == 0 }
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * nums 의 요소들을 실제로 변경시키면서 nums 를 copyOf 하지 않아 공간복잡도를 줄임
 * 모두 0으로 만들어지는지 nums[curr] 을 바꾸면서 배열을 순회하지 않아 시간복잡도를 O(n²+) → O(n)으로 개선
 */
class Solution {
    fun countValidSelections(nums: IntArray): Int {
        val n = nums.size
        val left = IntArray(n)
        val right = IntArray(n)
        var result = 0

        var totalLeft = 0
        var totalRight = 0
        for (i in 0 until n) {
            totalLeft += nums[i]
            left[i] = totalLeft

            totalRight += nums[n - i - 1]
            right[n - i - 1] = totalRight
        }

        for (i in 0 until n) {
            if (nums[i] == 0) {
                if (left[i] == right[i]) result+=2
                else if (left[i] - right[i] == 1) result+=1
                else if (right[i] - left[i] == 1) result+=1
            }
        }

        return result
    }
}

