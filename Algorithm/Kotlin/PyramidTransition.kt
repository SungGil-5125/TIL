class Solution {
    fun pyramidTransition(bottom: String, allowed: List<String>): Boolean {
        // 위에 올 수 있는 블록을 찾기 위해 생성
        val map = HashMap<String, MutableList<Char>>()
        for (pattern in allowed) {
            val key = pattern.substring(0, 2)
            val top = pattern[2]
            map.getOrPut(key) { ArrayList() }.add(top)
        }

        fun dfs(current: String, next: StringBuilder): Boolean {
            if (current.length == 1) return true // 피라미드 완성시 종료

            // 모든 층이 완성 되면 다음 층을 위해 next 초기화
            if (next.length == current.length - 1) {
                return dfs(next.toString(), StringBuilder())
            }

            // 중간에 놓을 수 있는 문자를 찾기 위해 index 사용
            val index = next.length
            val basePair = current.substring(index, index + 2)

            val possibleTops = map[basePair] ?: return false

            // 가능한 블록들을 하나씩 시도
            for (top in possibleTops) {
                next.append(top) // 블록 놓기

                // 재귀 호출해서 끝까지 성공하면 true 리턴
                if (dfs(current, next)) return true

                // 실패했다면 블록을 다시 빼고(Backtracking) 다음 후보 시도
                next.setLength(next.length - 1)
            }

            return false
        }

        return dfs(bottom, StringBuilder())
    }
}
