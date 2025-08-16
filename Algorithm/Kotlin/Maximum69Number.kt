class Solution {
    fun maximum69Number(num: Int): Int {
        val str = num.toString()
        var result = ""
        var used = false

        for (i in str) {
            if (!used && i == '6') {
                used = true
                result += '9'
            } else {
                result += i
            }
        }

        return result.toInt()
    }
}
