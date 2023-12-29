

//REVERSE SOLUTION
fun reverse(str: String): String {
    if (str.isEmpty()) return str
    //Calling Function Recursively
    return reverse(str.substring(1)) + str[0]
}

//IS PALINDROME SOLUTION
fun isPalindromeRecursion(s: String): Boolean {   // if length is 0 or 1 then String is palindrome
    if (s.isEmpty() || s.length == 1) return true
    if (s[0] == s[s.length - 1]) return isPalindromeRecursion(s.substring(1, s.length - 1))
    return false
}

//FIRST UPPERCASE SOLUTION
fun first(str: String): Char {
    if (str.isEmpty()) {
        return ' '
    }
    return if (Character.isUpperCase(str[0])) {
        str[0]
    } else {
        first(str.substring(1, str.length))
    }
}

//CAPITALIZE WORD SOLUTION
fun capitalizeWord(str: String): String {
    if (str.isEmpty()) {
        return str
    }
    var chr = str[str.length - 1]
    if (str.length == 1) {
        return chr.uppercaseChar().toString()
    }
    if ((str.substring(str.length - 2, str.length - 1) == " ")) {
        chr = chr.uppercaseChar()
    }
    return capitalizeWord(str.substring(0, str.length - 1)) + chr.toString()
}


//POWER SOLUTION
fun power(base: Int, exponent: Int): Int {
    if (exponent == 0) {
        return 1
    }
    return base * power(base, exponent - 1)
}


//PRODUCT OF ARRAY SOLUTION
fun productOfArray(a: IntArray, n: Int): Int {
    if (n <= 0) return 1
    return (productOfArray(a, n - 1) * a[n - 1])
}

//RECURSIVE RANGE SOLUTION
fun recursiveRange(num: Int): Int {
    if (num <= 0) {
        return 0
    }
    return num + recursiveRange(num - 1)
}
