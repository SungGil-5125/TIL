class Solution {
    fun removeSubfolders(folder: Array<String>): List<String> {
        val result = mutableListOf<String>()

        folder.sort()

        result.add(folder.first())
        for (i in 1 until folder.size) {
            val current = folder[i]

            if (!current.startsWith(result.last() + "/")) {
                result.add(current)
            }
        }

        return result
    }
}
