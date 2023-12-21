fun main() {
    println(longestPalindrome("abb"))
//    println(longestPalindrome2("abb"))
}

fun longestPalindrome(s: String): String {
    val l = s.length
    var size = 0
    var value = ""
    var i = 0
    var j = 1
    if (l == 1) {
        return s
    }
    while (i != j && i < l) {
        if (j - i <= size) {
            if (j == (l)) {
                i += 1
                j = i + 1
            } else
                j += 1
            continue
        }
        val d = s.substring(i, j)
        if (isPalindrome(d)) {
            if (size < j - i) {
                size = j - i
                value = d
            }
        }
        if (j == l) {
            i += 1
            j = i + 1
        } else
            j += 1
    }
    return value
}

fun isPalindrome(s: String): Boolean {
    return s == s.reversed()
}



fun longestPalindrome2(s: String): String {
    // to hold final substring indices
    var resultStart = 0
    var resultEnd = 0

    // check per char if equal, startIndex that checks until 0 and  endIndex that starts until end
    fun checkPalindrome(start: Int, end: Int) {
        var startIndex = start
        var endIndex = end
        while(startIndex >= 0 && endIndex < s.length && s[startIndex] == s[endIndex]) {
            startIndex--
            endIndex++
        }

        // check if longest
        if(endIndex - startIndex > resultEnd - resultStart) {
            resultEnd = endIndex
            resultStart = startIndex + 1
        }

    }

    for (iteration in s.indices) {
        if(iteration != 0) checkPalindrome(iteration - 1, iteration)
        checkPalindrome(iteration, iteration)
    }

    return s.substring(resultStart, resultEnd)
}