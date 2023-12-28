fun main() {
    println(factorial(3))
}

fun factorial(n: Int): Int {
    if (n < 0) {
        return -1
    }
    if (n == 0 || n == 1) {
        return 1
    }
    return n * factorial(n - 1)
}
