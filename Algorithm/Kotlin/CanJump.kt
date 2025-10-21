class Solution {
    fun canJump(nums: IntArray): Boolean {
        var longest = 0

        for (i in nums.indices) { // nums[i] 값 내에 범위로 계산하기 때문에 배열을 순회함
            // 배열을 모두 순회했지만 도달할 수 없는 경우 false 리턴
            if (i > longest) return false

            // 도달할 수 있는 가장 큰 값을 구함
            // i 는 현재 위치를 넣기 위해서 더함
            longest = maxOf(longest, nums[i] + i)

            // 이미 도달했는지 확인 후 true 리턴
            if (longest >= nums.size - 1) return true
        }

        return false
    }
}
