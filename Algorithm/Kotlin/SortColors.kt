class Solution {
    fun sortColors(nums: IntArray): Unit {
        var count0 = nums.count { it == 0 }
        var count1 = nums.count { it == 1 }
        var count2 = nums.count { it == 2 }

        for (i in 0 .. nums.size) {
            if (count0 != 0) {
                nums[i] = 0
                count0--
                continue
            }
            if (count1 != 0) {
                nums[i] = 1
                count1--
                continue
            }
            if (count2 != 0) {
                nums[i] = 2
                count2--
                continue
            }
        }
        println("nums is ${nums.map { it }}")
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * count 개수를 줄이는 연산 제거 및 count2 를 구해서 2를 넣는 분기문을 제거해서
 * 최종적으로 불필요한 연산을 제거했다.
 */
class Solution {
    fun sortColors(nums: IntArray): Unit {
        val count0 = nums.count { it == 0 }
        val count1 = nums.count { it == 1 }
        var index = 0

        for (i in 0 until count0) {
            nums[index++] = 0
        }

        for (i in 0 until count1) {
            nums[index++] = 1
        }

        for (i in index until nums.size) {
            nums[i] = 2
        }
    }
}
