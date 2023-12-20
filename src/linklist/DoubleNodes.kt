package linklist

data class DoubleNodes(
    var value: Int,
    var next: DoubleNodes? = null,
    var previous: DoubleNodes? = null
)