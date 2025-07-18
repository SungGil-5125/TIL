class Solution {
    fun getDecimalValue(head: ListNode?): Int {
        var current = head
        var str = ""
        while (current != null) {
            str += current.`val`
            current = current.next
        }
        return str.toInt(2)
    }
}
