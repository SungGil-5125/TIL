class Solution {
   fun zeroFilledSubarray(nums: IntArray): Long {
        var count = 0L
        var result = 0L

        for (num in nums) {
            if (num == 0) {
                count++
                result+=count
            } else {
                count = 0
            }
        }

        return result
    }
}
