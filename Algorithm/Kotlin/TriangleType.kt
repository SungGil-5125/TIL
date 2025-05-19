class Solution {
     fun triangleType(nums: IntArray): String {
        val num0 = nums[0]
        val num1 = nums[1]
        val num2 = nums[2]

        if (num0 + num1 <= num2 || num1 + num2 <= num0 || num0 + num2 <= num1) return "none"
        if (num0 == num1 && num0 == num2) return "equilateral"
        if (num0 == num1 || num0 == num2 || num1 == num2) return "isosceles"
        if ((num0 + num1) > num2 && (num0 + num2) > num1 && (num1 + num2) > num0) return "scalene"
        return "none"
    }
}
