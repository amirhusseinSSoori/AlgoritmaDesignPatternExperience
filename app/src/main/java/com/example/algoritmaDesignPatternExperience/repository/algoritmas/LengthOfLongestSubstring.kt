package com.example.algoritmaDesignPatternExperience.repository.algoritmas

/**
Long Substring Without Repeating Characters

Given a string , find the length of the longest
substring without repeating  characters.

Example 1 :
Input: "abcabcbb"
Output: 3
Explanation: The answer is "b" , with the length of 3.



Example 2 :
Input: "bbbbbbb"
Output: 1
Explanation: The answer is "b" , with the length of 1.




Example e :
Input: "pwwkew"
Output: 1
Explanation: The answer is "wke" , with the length of 3.


Note that the answer must be a substring ,"pwke" is
a subsequence and not a substring



 *
 */
class LengthOfLongestSubstringImp() : LengthOfLongestSubstring {

    override fun firstSolutions(s: String): Int {
        val n = s.length
        var ans = 0
        val index = IntArray(128)
        var j = 0
        var i = 0
        while (j < n) {
            val c = s[j].code
            val dex = index[c]
            i = dex.coerceAtLeast(i)
            ans = ans.coerceAtLeast(j - i + 1)
            index[s[j].code] = j + 1
            j++
        }
        return ans
    }

    override fun secondSolutions(s: String): Int {
        val n = s.length
        var ans = 0
        val map: MutableMap<Char, Int> = HashMap<Char, Int>()

        var j = 0
        var i = 0
        while (j < n) {
            if (map.containsKey(s[j])) {
                i = map[s[j]]!!.coerceAtLeast(i)
            }
            ans = ans.coerceAtLeast(j - i + 1)
            map[s[j]] = j + 1
            j++
        }

        return ans
    }

    override fun thirdSolutions(s: String): Int {
        val n = s.length
        val set: MutableSet<Char> = HashSet()
        var ans = 0
        var i = 0
        var j = 0
        while (i < n && j < n) {
            if (!set.contains(s[j])) {
                set.add(s[j++])
                ans = ans.coerceAtLeast(j - i)
            } else {
                set.remove(s[i++])
            }
        }
        return ans
    }


}

interface LengthOfLongestSubstring {
    fun firstSolutions(s: String): Int
    fun secondSolutions(s: String): Int
    fun thirdSolutions(s: String): Int
}
