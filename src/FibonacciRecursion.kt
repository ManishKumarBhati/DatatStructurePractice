fun main() {
    println(fibonacci(3))
}

fun fibonacci(n: Int): Int {
    if (n < 0) {
        return -1
    }
    if (n == 0 || n == 1) {
        return n
    }
    return fibonacci(n - 1) + fibonacci(n - 2)
}
