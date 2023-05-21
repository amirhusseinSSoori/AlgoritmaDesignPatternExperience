package com.example.algoritmaDesignPatternExperience.repository.algoritmas

/**
Sqrt(x)

Topic : Binary Search ,Math

Companies : Microsoft , Google ,Linkedin , Amazon

Implement in sqrt(int x).

Compute and return the square root of x, where x
is guaranteed to be a non-negative integer.

Since the return type is an integer , the decimal
digits integer part of the result is returned.

Example 1:
Input:4
Output:2


Example 2:
Input:8
Output:2

Explanation:
The square root of 8 is 2.82842.., and since the decimal part is truncated, 2 is returned.



 */
class Sqrt {
    fun mySqrt(x: Int): Int {
        if (x <= 1) {
            return x
        }
        var lo = 1
        var hi = x / 2
        while (lo < hi) {
            val mid = lo + (hi - lo + 1) / 2
            val t = x / mid
            if (mid == t) {
                return mid
            } else if (mid > t) {
                hi = mid - 1
            } else {
                lo = mid
            }
        }
        return hi
    }
}
