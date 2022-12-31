package com.example.algoritmaexperiencekotlin.repository

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
fun main(){
    print(17/2)
}