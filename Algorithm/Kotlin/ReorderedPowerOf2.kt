class Solution {
    fun reorderedPowerOf2(n: Int): Boolean {
        val str = n.toString()
        val nFreq = IntArray(10)
        str.forEach { char ->
            nFreq[char.digitToInt()]++
        }

        val powersFreq = getPowersOf2Frequencies()

        for (powerFreq in powersFreq) {
            if (nFreq.contentEquals(powerFreq)) {
                return true
            }
        }

        return false
    }

    private fun getPowersOf2Frequencies(): List<IntArray> {
        val result = mutableListOf<IntArray>()
        var power = 1

        for (i in 0..29) {
            val digitFreq = IntArray(10)
            val str = power.toString()

            str.forEach { char ->
                digitFreq[char.digitToInt()]++
            }

            result.add(digitFreq)
            power *= 2
        }
        return result
    }
}
