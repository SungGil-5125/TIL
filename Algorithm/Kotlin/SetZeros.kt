class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val n = matrix.size
        val m = matrix[0].size

        val nArray = IntArray(n)
        val mArray = IntArray(m)

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (matrix[i][j] == 0) {
                    nArray[i] = -1
                    mArray[j] = -1
                }
            }
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (nArray[i] == -1 || mArray[j] == -1) {
                    matrix[i][j] = 0
                }
            }
        }
    }
}
