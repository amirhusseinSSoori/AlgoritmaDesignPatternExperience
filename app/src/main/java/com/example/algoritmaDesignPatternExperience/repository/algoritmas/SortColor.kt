package com.example.algoritmaDesignPatternExperience.repository.algoritmas

/**
Sort Colors

Topic : Array ,Sort ,Two Pointers

Companies : FaceBook ,Amazon , Google , Yahoo,

Given an array with n objects colored red ,white or blue ,
sort them in-place so that objects of the same color are adjacent
,with the colors in the order red,white and blue.

Here, we will use the integers 0, 1,and 2 to represent
the color red,white ,and blue respectively.

Note : You are not suppose to use  the library's sort function for this problem.

Example:
Input :[2,0,2,1,1,0]
OutPut:[0,0,1,1,2,2]


Follow up:
A rather straight forward solution
is a two-pass algorithm using
counting sort.
First, iterate the array counting number of 0's, 1's,
and 2's,then overwrite array with total number of 0's.
then 1's and followed by 2's.Could you come up with a one-pass algorithm
using only constant space?

 */

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