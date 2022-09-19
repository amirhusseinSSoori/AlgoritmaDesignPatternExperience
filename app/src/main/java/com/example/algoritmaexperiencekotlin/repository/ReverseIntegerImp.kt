package com.example.algoritmaexperiencekotlin.repository

/**
Reverse Integer

Topic : Math

Companies : Adobe , Alibaba , Amazon  , FaceBook
Google , Microsoft , NetEase ,Lyft, Uber , Airbnb

Given a 32-bit signed integer reverse digits of an integer .
Example 1:
Input 123
outPut 321

Example 2:
Input -123
outPut -321

Example 3:
Input 120
outPut 21


Note
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range :[-321 ,231,-1].
Fore the purpose of this problem ,
assume that your function returns 0 when that reversed integer overflows.


 */

class ReverseIntegerImp() : ReverseInteger {
    override fun solution(x: Int): Int {
        var x = x
        var out: Long = 0
        while (x != 0) {
            out = out * 10 + x % 10
            x /= 10
        }
        return if (out > Int.MAX_VALUE || out < Int.MIN_VALUE) 0 else out.toInt()
    }
}


interface ReverseInteger {
    fun solution(x: Int): Int
}

