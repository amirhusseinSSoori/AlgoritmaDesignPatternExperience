package com.example.algoritmaexperiencekotlin.repository


/**
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution,
and you may not use the same element twice

Example :
Given nums = [2 ,7 ,11 ,15] , target = 9,

Because nums[0] + nums[1] = 2 +7 = 9 ,
return [0, 1].
 */
fun twoSum(nums: IntArray, target: Int, solutions: Int = 0): IntArray {
    if (solutions == 0) {
        val map: MutableMap<Int, Int> = HashMap()
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, i)
            }
            map[nums[i]] = i
        }
    } else {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[j] == target - nums[i]) {
                    return intArrayOf(i, j)
                }
            }
        }

    }
    throw IllegalArgumentException("No two sum solution")
}

