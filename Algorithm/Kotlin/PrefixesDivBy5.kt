class Solution {
    fun prefixesDivBy5(nums: IntArray): List<Boolean> {
        val result = mutableListOf<Boolean>()
        var current = 0

        for (num in nums) {
            // 2진수를 10진수로 변경하면서 나머지 구하기
            current = (current * 2 + num) % 5
            result.add(current == 0)
        }

        return result
    }
}
