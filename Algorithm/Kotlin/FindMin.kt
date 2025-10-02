class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1

        while (left < right) {
            val mid = (left + right) / 2
            if (nums[mid] <= nums[right]) { // nums 는 정렬된 기준이니 오른쪽에 더 큰 값이 있다면 왼쪽으로 이동해야함
                right = mid
            } else {
                left++
            }
        }

        return nums[left]
    }
}
