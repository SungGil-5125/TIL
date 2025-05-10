class Solution {
    fun minSum(nums1: IntArray, nums2: IntArray): Long {
        var sum1 = 0L
        var sum2 = 0L
        val zeros1 = nums1.count { it == 0 }
        val zeros2 = nums2.count { it == 0 }

        nums1.forEach { sum1 += it }
        nums2.forEach { sum2 += it }

        val minNum1 = calculateMinNum(sum1, zeros1)
        val minNum2 = calculateMinNum(sum2, zeros2)

        if (sum1 == sum2) {
            return when {
                zeros1 == 0 && zeros2 != 0 -> -1
                zeros2 == 0 && zeros1 != 0 -> -1
                zeros1 > zeros2 -> minNum1
                else -> minNum2
            }
        }

        // 값을 더해도 의미가 없을때 계산
        if (sum1 > sum2 && zeros2 == 0 || minNum1 > minNum2 && zeros2 == 0) return -1
        if (sum2 > sum1 && zeros1 == 0 || minNum2 > minNum1 && zeros1 == 0) return -1

        return maxOf(minNum1, minNum2)
    }

    private fun calculateMinNum(sum: Long, zeros: Int): Long {
        var minNum = sum
        for (i in 1..zeros) {
            minNum += 1
        }
        return minNum
    }
}
