class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val map: HashMap<Int, Int> = hashMapOf()

        for (num in nums) {
            var count = map.getOrDefault(num, 0)
            if (count != 0) return true
            map[num] = ++count
        }

        return false
    }
}

/**
 * 풀이 후 다시 작성 한 코드
 *
 * HashMap 을 사용하는 것이 아닌 HashSet 를 사용함으로써 불필요한 count 증가 로직 삭제
 */
class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set: HashSet<Int> = hashSetOf()
        for (num in nums) {
            if (set.contains(num)) {
                return true
            }

            set.add(num)
        }

        return false
    }
}
