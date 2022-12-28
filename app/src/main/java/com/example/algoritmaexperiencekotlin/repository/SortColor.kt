package com.example.algoritmaexperiencekotlin.repository

class SortColor {
    private val RED = 0
    private val WHITE = 1
    private val BLUE = 2
    fun solution(nums: Array<Int>): Array<Int> {
        var redEnd = -1
        var whiteEnd = -1
        for (i in nums.indices) {
            val v = nums[i]
            nums[i] = BLUE
            if (v == RED) {
                nums[++whiteEnd] = WHITE
                nums[++redEnd] = RED
            } else if (v == WHITE) {
                nums[++whiteEnd] = WHITE
            }
        }
        return nums
    }

}