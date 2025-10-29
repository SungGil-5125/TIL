class Solution {
    fun smallestNumber(n: Int): Int {
        // n을 2진수로 변환하여 비트 개수 확인
        val bitLength = n.toString(2).length
        // 비트 개수만큼 왼쪽으로 밀어서 - 1 빼기
        return (1 shl bitLength) - 1
    }
}
