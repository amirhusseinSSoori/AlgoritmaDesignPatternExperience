package com.example.algoritmaDesignPatternExperience.repository.algoritmas

import kotlin.math.abs

/**
Divide Two Integer

Topic : binary Search , Math

Companies : FaceBook

Given two integers dividend  and divisor ,divide two integers without
using multiplication ,division and mod operator.

Return the quotient after dividing dividend by divisor.
The integer dividend should truncate toward zero.

Example 1:
Input:dividend = 10,divisor = 3
Output:3

Example 2:
Input:dividend = 7,divisor = -3
Output: -2


Note: Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0. Assume we are dealing with an environment which
could only store integers within the 32-bit signed integer range:[-231,231 -1]
.For the purpose of this problem, assume that your function returns 231 -1 when division result overflows

 */

class DivideTwoIntegerImpl : DivideTwoInteger {
    override fun solution(dividend: Int, divisor: Int): Int {
        if (divisor == 0) {
            return Int.MAX_VALUE
        }
        if (dividend == 0) {
            return 0
        }
        if (divisor == -1) {
            return if (dividend == Int.MIN_VALUE) Int.MAX_VALUE else -dividend
        }
        val isNegative = dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0
        var longDividend = abs(dividend.toLong())
        val longDivisor = abs(divisor.toLong())
        var res = 0
        var bit = Integer.SIZE - 1
        while (bit >= 0 && longDividend >= longDivisor) {
            if (longDividend >= longDivisor shl bit) {
                res = res or (1 shl bit)
                longDividend -= longDivisor shl bit
            }
            bit--
        }
        return if (isNegative) -res else res
    }
}

interface DivideTwoInteger {
    fun solution(dividend: Int, divisor: Int): Int
}

