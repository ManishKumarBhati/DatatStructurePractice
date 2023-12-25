/*
Regular Expression Matching
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).
*/
fun main() {
    println(isMatch2("aa", "a*"))
}

fun isMatch(s: String, p: String): Boolean {
    if (p.isEmpty()) {
        return s.isEmpty()
    }

    val firstMatch = s.isNotEmpty() && (p[0] == s[0] || p[0] == '.')

    return if (p.length >= 2 && p[1] == '*') {
        isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p))
    } else {
        firstMatch && isMatch(s.substring(1), p.substring(1))
    }
}

fun isMatch2(s: String, p: String): Boolean {
    try {
        if (p.contains(".") || p.contains("*")) {
            return s.matches(regex = Regex(p))
        }
    }catch ( e:Exception){

    }

    return s == p
}


// time: O(lenS * lenP)
// space: O(lenS * lenP)
class Solution {
    private companion object {
        private const val PLACE_HOLDER_MULTIPLE = '*'
        private const val PLACE_HOLDER_SINGLE = '.'
    }

    fun isMatch(s: String, p: String): Boolean {
        val lenS = s.length
        val lenP = p.length

        val dp = Array(lenS + 1) { BooleanArray(lenP + 1) { false } }
        dp[0][0] = true

        for (idxP in 0..<lenP) {
            if (p[idxP] == PLACE_HOLDER_MULTIPLE && dp[0][idxP - 1]) {
                dp[0][idxP + 1] = true
            }
        }

        for (idxS in 0..<lenS) {
            for (idxP in 0..<lenP) {
                if (p[idxP] == PLACE_HOLDER_SINGLE) {
                    dp[idxS + 1][idxP + 1] = dp[idxS][idxP]
                }

                if (p[idxP] == s[idxS]) {
                    dp[idxS + 1][idxP + 1] = dp[idxS][idxP]
                }

                if (p[idxP] == PLACE_HOLDER_MULTIPLE) {
                    if (p[idxP - 1] != s[idxS] && p[idxP - 1] != PLACE_HOLDER_SINGLE) {
                        dp[idxS + 1][idxP + 1] = dp[idxS + 1][idxP - 1]
                    } else {
                        dp[idxS + 1][idxP + 1] = (dp[idxS + 1][idxP] || dp[idxS][idxP + 1] || dp[idxS + 1][idxP - 1])
                    }
                }
            }
        }

        return dp[lenS][lenP]
    }
}