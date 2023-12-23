fun main() {
    println(myAtoi("11111111111"))
//    println(leo2("words and 987"))
}

fun myAtoi2(s: String): Int {

    var finalNumber = ""
    var isNegative = false

    run maish@{
        s.forEach {
            if (it.isDigit())
                finalNumber += it
            else if (finalNumber.isEmpty() && (it == '-' || it == '+')) {
                finalNumber += it
                isNegative = it == '-'
            } else if (!it.isDigit() && (finalNumber.isNotEmpty() || !it.isWhitespace()))
                return@maish
        }
    }

    if (!finalNumber.contains("[0-9]".toRegex()))
        return 0

    return try {
        finalNumber.toInt()
    } catch (e: Exception) {
        if (isNegative) {
            -2147483648
        } else {
            2147483647
        }
    }
}
fun myAtoi(i: String): Int {
    val s = i.trim()
    var i = 0
    var isPositive = 1
    var output = 0

    while (i < s.length && s[i] == ' ') {
        i++
    }

    if (i < s.length && (s[i] == '-' || s[i] == '+')) {
        isPositive = if (s[i] == '-') -1 else 1
        i++
    }

    while (i < s.length && Character.isDigit(s[i])) {
        val digit = s[i] - '0'

        if (output > Int.MAX_VALUE / 10 || (output == Int.MAX_VALUE / 10 && digit > 7)) {
            return if (isPositive == 1) Int.MAX_VALUE else Int.MIN_VALUE
        }

        output = output * 10 + digit
        i++
    }

    return output * isPositive
}
