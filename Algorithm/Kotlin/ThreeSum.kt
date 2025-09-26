class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        var left: Int
        var right: Int
        val result: MutableList<MutableList<Int>> = mutableListOf()

        for (i in 0 until nums.size - 2) {
            // 이전 고정값과 같은 값일때 연산하지 않도록 분기문 추가
            if (i > 0 && nums[i] == nums[i - 1]) continue

            left = i + 1
            right = nums.size - 1

            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                if (sum == 0) {
                    result.add(mutableListOf(nums[i], nums[left], nums[right]))
                    // 중복 값일때 연산 하지 않도록 포인터 이동
                    while (left < right && nums[left] == nums[left + 1]) left++
                    while (left < right && nums[right] == nums[right - 1]) right--
                    // 추가적인 정답이 있는지 확인하기 위해서 포인터 이동
                    left++
                    right--
                } else if (sum < 0) {
                    // 0 보다 작을때 더 큰값을 더하기 위해서 오른쪽으로 포인터 이동
                    left++
                } else {
                    // 0 보다 클때 더 작은 값을 더하기 위해서 왼쪽으로 포인터 이동
                    right--
                }
            }
        }

        return result
    }
}
