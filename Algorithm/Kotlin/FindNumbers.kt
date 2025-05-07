// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/?envType=daily-question&envId=2025-05-07
class Solution {
    fun findNumbers(nums: IntArray): Int {
        var result = 0
        nums.forEach { num ->
            val isEvenNumber = num.toString().length % 2 == 0
            if (isEvenNumber) result ++
        }
        return result
    }
}
