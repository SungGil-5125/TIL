class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()

        for (i in 0 until numRows) {
            val list = mutableListOf<Int>()
            list.add(1)

            if (i == 1) list.add(1)
            if (i >= 2) {
                val prev = result[i - 1]
                for (j in 1 until prev.size) {
                    val prev1 = prev[j - 1]
                    val current = prev[j]
                    list.add(current + prev1)
                    if (prev.lastIndex == j) list.add(1)
                }
            }

            result.add(list)
        }

        return result
    }
}
