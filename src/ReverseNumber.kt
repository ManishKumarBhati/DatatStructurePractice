import kotlin.math.abs

fun main() {
    println(reverse(-2147483648))
}

fun reverse(x: Int): Int {
    var num = abs(x)
    var rev: Long = 0
    while (num != 0) {
        val mod = num % 10
        rev = rev * 10 + mod
        num /= 10
    }
    if (rev > Int.MAX_VALUE || -rev < Int.MIN_VALUE) {
        return 0
    }

    return if (x < 0) {
        -rev.toInt()
    } else {
        rev.toInt()
    }

}

fun test(n: Long): Int {
    var temp = abs(n)
    var reversed: Long = 0
    while (temp > 0) {
        val lastDigit = temp % 10
        reversed = (reversed * 10) + lastDigit
        temp /= 10
    }

    if (reversed > Int.MAX_VALUE || -reversed < Int.MIN_VALUE) {
        return 0
    }

    return if (n < 0) {
        -reversed.toInt()
    } else {
        reversed.toInt()
    }
}

fun reverse2(n: Int) {
    if (n <= 0) return

    // remainder
    val rem = n % 10
//    rev = (rev * 10) + rem
    reverse2(n / 10)
}
