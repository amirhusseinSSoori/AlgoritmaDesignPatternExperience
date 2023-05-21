package com.example.algoritmaDesignPatternExperience.repository.algoritmas


/**
ValidNumber

Topic : Math ,String

Companies : FaceBook ,Google   , LinkdlLn

Validate if a given string can be interpreted as a decimal number.


Some example:
"0" => true
" 0.1 "=> true
"abc" => false
"1 a" => false
"2e10" => true
-09e3 => true
"  1e" => false
"53.5e93" => true
"-+3" => false
" 6e-1" => true
"--6" => false

Note :It is intended for the problem statement to be ambiguous.
You should gather all requirements up front before implementing one.
However,here is a list of characters that can be in a valid decimal number:
Number 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."

Of course, the context of these characters also matters in the input.


 */


class ValidNumber {
    fun isNumber(s: String): Boolean {
        var s = s
        s = s.trim { it <= ' ' }
        var hasDot = false
        var hasExp = false
        var hasNum = false
        val num = s.toCharArray()
        for (i in num.indices) {
            if (num[i] in '0'..'9') {
                hasNum = true
            } else if (num[i] == '.') {
                if (hasExp || hasDot) {
                    return false
                }
                hasDot = true
            } else if (num[i] == 'e') {
                if (hasExp || !hasNum) {
                    return false
                }
                hasNum = false
                hasExp = true
            } else if (num[i] == '-' || num[i] == '+') {
                if (i != 0 && num[i - 1] != 'e') {
                    return false
                }
            } else {
                return false
            }
        }
        return hasNum
    }
}
