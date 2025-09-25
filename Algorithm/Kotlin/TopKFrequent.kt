class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val result = IntArray(k)
        val map: HashMap<Int, Int> = HashMap()
        for (num in nums) {
            var count = map.getOrDefault(num, 0)
            map[num] = ++count
        }

        val maxHeap = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.second })
        for ((key, value) in map) {
            maxHeap.offer(Pair(key, value))
        }

        for (i in 0 until k) {
            result[i] = maxHeap.poll().first
        }

        return result
    }
}
