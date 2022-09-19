package com.example.algoritmaexperiencekotlin.repository

/**
Median of Two sorted arrays

Topic : Array Binary Search Divide and conquer

Companies : Adobe , Alibaba , Amazon , Baidu , FaceBook , Goldman Sachs
Google , Microsoft , NetEase , Tencent , Two Sigma , Vmware, Walmart Labs

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. the overall run time complexity should be 0 (log (m+n)).
You may assume nums1 and nums2 cannot be both empty.

Example 1 :
nums1 = [1,3]
nums2 = [2]
The median is 2.0

Exampel 2 :
nums1 =[1,2]
nums2 =[3,4]
the median is (2+3) / 2 = 2.5




 */

class MedianSortedArraysImp : MedianSortedArrays {
    override fun findMedianSortedArrays(A: IntArray, B: IntArray): Double {
        var a = A
        var b = B
        var m = a.size
        var n = b.size
        if (m > n) { // to ensure m<=n
            val temp = a
            a = b
            b = temp
            val tmp = m
            m = n
            n = tmp
        }
        var iMin = 0
        var iMax = m
        val halfLen = (m + n + 1) / 2
        while (iMin <= iMax) {
            val i = (iMin + iMax) / 2
            val j = halfLen - i
            if (i < iMax && b[j - 1] > a[i]) {
                iMin = i + 1 // i is too small
            } else if (i > iMin && a[i - 1] > b[j]) {
                iMax = i - 1  // i is too big
            } else {  // i is perfect
                val maxLeft: Int = if (i == 0) {
                    b[j - 1]
                } else if (j == 0) {
                    a[i - 1]
                } else {
                    a[i - 1].coerceAtLeast(b[j - 1])
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft.toDouble()
                }
                var minRight = 0
                minRight = if (i == n) {
                    b[j]
                } else if (i == m) {
                    b[j]
                } else {
                    b[j].coerceAtMost(a[i])
                }
                return (maxLeft + minRight) / 2.0
            }
        }
        return 0.0
    }

}

interface MedianSortedArrays {
    fun findMedianSortedArrays(A: IntArray, B: IntArray): Double
}
