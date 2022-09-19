package com.example.algoritmaexperiencekotlin.repository

/**
 *
String to Integer (atoi)
Implement atio which converts a string to an integer.

The function first discards as many whitespaces character as
necessary until the first non-whitespace character is found.
Then,starting from this character ,takes an optional initial
plus or minus sign followed by as many numerical digits as possible
, numerical value.

the string can contain additional characters after those that from the integral number,
which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid
integral number , or if no such sequence exits because either str is empty or
it contains only whitespace characters , no conversion is performed.

If no valid conversion could be performed ,a zero value is returned.

Note :
only the space character " is considered as whitespace character.
Assume we are dealing with only environment which could only store integers
within the 32-bit signed integer range:
[-231,231 - 1].If the numerical value iso ut of the range of representable values,
INT_MAX(231 -1) or INT_MIN (-231) is returned.


Example 1:
Input:"42"
OutPut :42


Example 2:
Input:"  -42"
OutPut:  -42

Explanation:
The first non-whitespace
character is '-',which is the minus sign.
then taker as many numerical digits as possible,which gets 42.


Example 3:
Input:"4192 with words"
OutPut:  41193

Explanation:
Conversion stops at digit '3' as the next character is not a numerical digit.


Example 4:
Input:"words and 987"
OutPut:  0

Explanation:
the first non-whitespace character is 'w'
,which is not a numerical digit or a+/- sign.
Therefor no valid conversion could be performed



Example 5:
Input:"-91283472332"
OutPut:  -214783648

Explanation:
The Number "-91283472332" is out of the range of a 32-bit signed integer .
Therefore INT_MIN(-231) is returned

 */
class StringToIntegerImp : StringToInteger {
    override fun solution(str: String?): Int {
        //Validate input
        var str = str
        if (str == null || str.isEmpty()) return 0
        var longRes: Long = 0 //result can be out of integer range
        // whitespace
        str = str.trim { it <= ' ' }
        //sign
        var neg = false // is negative or positive
        if (str[0] == '-') {
            neg = true
            str = str.substring(1, str.length)
        }
        //calculation
        var i = 0
        while (i < str.length) { //calculate without sign
            val c = str[i]
            longRes = if (c in '0'..'9') {
                longRes * 10 + (c - '0')
            } else break //break when not a digit
            i++
        }
        longRes = if (neg) longRes * -1 else longRes //add sign
        //out of range
        if (longRes > Int.MAX_VALUE) {
            return Int.MAX_VALUE
        } else if (longRes < Int.MIN_VALUE) {
            return Int.MIN_VALUE
        }
        return longRes.toInt()
    }
}


interface StringToInteger {
    fun solution(str: String?): Int
}
