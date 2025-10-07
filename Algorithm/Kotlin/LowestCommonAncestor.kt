class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null
        val left = root.left
        val right = root.right

        return if (p!!.`val` < root.`val` && q!!.`val` < root.`val`) {
            // 현재 노드의 값이 더 큰 경우 왼쪽 더 작은 값의 자식 노드로 이동
            lowestCommonAncestor(left, p, q)
        } else if (p.`val` > root.`val` && q!!.`val` > root.`val`) {
            // 현재 노드의 값이 더 작은 경우 오른쪽 더 큰 값의 자식 노드로 이동
            lowestCommonAncestor(right, p, q)
        } else {
            // LCA 인 경우 현재 노드를 리턴
            root
        }
    }
}
