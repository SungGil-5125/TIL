class MinStack {
    private var lastIndex = -1
    private val stack: MutableList<Pair<Int, Int>> = mutableListOf()

    fun push(`val`: Int) {
        if (lastIndex == -1) {
            stack.add(Pair(`val`, `val`))
        } else {
            stack.add(Pair(`val`, minOf(`val`, getMin())))
        }
        lastIndex++
    }

    fun pop() {
        stack.removeAt(lastIndex)
        lastIndex--
    }

    fun top(): Int {
        val (`val`, _) = stack[lastIndex]
        return `val`
    }

    fun getMin(): Int {
        val (_, latestMin) = stack[lastIndex]
        return latestMin
    }
}
