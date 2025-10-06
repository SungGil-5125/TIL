class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        val leftDepth = maxDepth(root.left)
        val rightDepth = maxDepth(root.right)

        return maxOf(leftDepth, rightDepth) + 1
    }
}
