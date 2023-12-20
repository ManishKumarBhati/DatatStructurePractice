fun main() {
    println(longestPalindrome("abb"))
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