class Solution {
    fun finalValueAfterOperations(operations: Array<String>): Int {
        var result = 0

        for (operation in operations) {
            if (operation == "--X" || operation == "X--") result--
            if (operation == "++X" || operation == "X++") result++
        }

        return result
    }
}
