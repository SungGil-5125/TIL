class Solution {
    fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
        val n = arr.size
        var result = 0
        for (i in 0 until n - 2) {
            for (j in i + 1 until n - 1) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (k in j + 1 until n) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) result++
                    }
                }
            }
        }
        return result
    }
}
