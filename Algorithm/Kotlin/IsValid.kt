class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        val opens = listOf('(', '[', '{')
        val closes = listOf(')', ']', '}')

        for (i in s.indices) {
            val char = s[i]
            if (char in opens) stack.push(char)
            if (char in closes) {
                if (stack.isEmpty()) return false
                val pop = stack.pop()
                when (pop) {
                    '(' -> {
                        if (char != ')') return false
                    }

                    '[' -> {
                        if (char != ']') return false
                    }

                    '{' -> {
                        if (char != '}') return false
                    }
                }
            }
        }

        return stack.empty()
    }
}
