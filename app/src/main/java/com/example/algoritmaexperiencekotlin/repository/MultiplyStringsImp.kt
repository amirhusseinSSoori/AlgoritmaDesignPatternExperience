package com.example.algoritmaexperiencekotlin.repository

/**
Multiply Strings

Topic : Math , String

Companies : Google , Houzz , Huawei  , FaceBook ,
Microsoft   , Zillow

Given two non-negative integers num1 and num2 represented as strings,
return the product of num1 and num2, also represented as a string.

Example 1:
Input : num1 = "2" ,num2 = "3"
OutPut : "6"

Example 2:
Input : num1 = "123" ,num2 = "456"
OutPut :"56088"


Note : The length of both num1 and num2 is < 110 . Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger Library or convert the input to integer directly.
 */

class MultiplyStringsImp : MultiplyStrings {
    override fun solution(num1: String?, num2: String?): String {
        if (num1 == null || num2 == null) {
            return ""
        }
        if ("0" == num1 || "0" == num2) {
            return "0"
        }
        val m = num1.length
        val n = num2.length
        val product = IntArray(m + n)
        for (i in m - 1 downTo 0) {
            val x = num1[i].code - '0'.code
            for (j in n - 1 downTo 0) {
                product[i + j + 1] += x * (num2[j].code - '0'.code)
                product[i + j] += product[i + j + 1] / 10
                product[i + j + 1] %= 10
            }
        }
        val result = StringBuilder()
        for (p in product) {
            if (p != 0 || result.isNotEmpty()) {
                result.append(p)
            }
        }
        return result.toString()
    }
}


interface MultiplyStrings {
    fun solution(num1: String?, num2: String?): String
}