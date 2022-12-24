package com.example.algoritmaexperiencekotlin.repository

import java.util.ArrayList

class GravyCodImp {
    fun solution(n: Int): List<Int> {
        val results: MutableList<Int> = ArrayList()
        results.add(0)
        for (i in 0 until n) {
            val inc = 1 shl i
            for (j in results.indices.reversed()) {
                results.add(results[j] + inc)
            }
        }
        return results
    }
}
