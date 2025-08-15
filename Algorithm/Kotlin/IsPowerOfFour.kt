class Solution {
    fun isPowerOfFour(n: Int): Boolean {
        val i = Math.log(n.toDouble()) / Math.log(3.toDouble())
        return if (n <= 0) false else i == Math.floor(i)
    }
}
