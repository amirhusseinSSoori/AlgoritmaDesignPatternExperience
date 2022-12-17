package com.example.algoritmaexperiencekotlin.repository


/**
Palindrome Number

Topic : Math

Companies : Adobe , Alibaba , Amazon  , FaceBook ,
Microsoft   , Tencent

Determine whether an integer is a palindrom .An integer is a palindrome when it reads th same backward
as forward.

Example 1:
Input :121
OutPut :true

Example 2:
Input :-121
OutPut :false
Explanation :From left to right ,it reads -121 From right to left, it becomes 121-.
ThereFore it is not a palindrome.


Example 3:
Input :10
OutPut :false

Explanation :Reads 01 from right to left.ThereFore it is right to left.
There it is not a palindrome.

Follow up:
Could you solve it without converting the integer to a string?

 */
class PalindromeImp : Palindrome {
    override fun solution(input: Int): Boolean {
        var x = input
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false
        }
        var revertedNumber = 0
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10
            x /= 10
        }
        return x == revertedNumber || x == revertedNumber / 10
    }

}

interface Palindrome {
    fun solution(input: Int): Boolean
}


