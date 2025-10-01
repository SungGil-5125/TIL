class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = piles.max()

        while (left < right) {
            val mid = (right + left) / 2

            if (canFinishInTime(piles, mid, h)) {
                right = mid // 더 작은 속도를 찾기 위해서 오른쪽 포인터를 이동 시킴
            } else {
                left = mid + 1 // 더 큰 속도를 구하기 위해서 1을 더함
            }
        }

        return left
    }

    private fun canFinishInTime(piles: IntArray, k: Int, h: Int): Boolean {
        var totalTime = 0

        for (pile in piles) {
            // 반올림으로 각 pile 만큼 얼마나 시간이 걸리는지 계산
            val timeNeeded = ceil(pile.toDouble() / k).toInt()
            totalTime += timeNeeded

            if (totalTime > h) { // 총 시간이 이미 h 보다 크다면 false 리턴
                return false
            }
        }

        return totalTime <= h
    }
}
