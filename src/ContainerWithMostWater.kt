import kotlin.math.max
import kotlin.math.min

/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.


*/
fun main() {
    println(maxArea(intArrayOf(1, 2,3,4,5)))
}

fun maxArea(height: IntArray): Int {
    var lx = 0
    var rx = height.size - 1
    var capacity = 0
    while (lx != rx) {
        val lh=height[lx]
        val rh=height[rx]

        capacity = max(capacity, min(lh, rh) * (rx - lx))
        if (lh > rh) {
            rx -= 1
        } else {
            lx += 1
        }
    }
    return capacity
}