class Solution {
    fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var prev = dummy
        var current = head
        val set = nums.toSet()

        while (current != null) {
            if (current.`val` in set) {
                // 같은 노드 객체 주소를 가리키기 때문에 prev 의 next 가 움직이면 dummy 도 움직임
                prev.next = current.next
            } else {
                prev = current
            }

            current = current.next
        }

        return dummy.next
    }
}
