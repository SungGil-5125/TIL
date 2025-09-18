class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        val tree = invertTreeRec(root)
        return tree
    }

    private fun invertTreeRec(treeNode: TreeNode?): TreeNode? {
        if (treeNode == null) return null
        val temp = treeNode.right
        treeNode.right = treeNode.left
        treeNode.left = temp
        invertTreeRec(treeNode.left)
        invertTreeRec(treeNode.right)
        return treeNode
    }
}
