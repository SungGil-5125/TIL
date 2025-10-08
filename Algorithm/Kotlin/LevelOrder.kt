class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val result = mutableListOf<List<Int>>()
        val queue = LinkedList<TreeNode>()

        queue.add(root)

        while (queue.isNotEmpty()) {
            val level = queue.size // 자식 노드들의 개수를 구함
            val currentLevel = mutableListOf<Int>()

            repeat(level) { // 자식 노드 개수 만큼의 반복문으로 자식 노드를 result 리스트에 넣고, 다음 자식 노드를 queue 에 저장함
                val current = queue.removeFirst()
                currentLevel.add(current.`val`)

                current.left?.let { queue.add(it) }
                current.right?.let { queue.add(it) }
            }

            result.add(currentLevel)
        }

        return result
    }
}
