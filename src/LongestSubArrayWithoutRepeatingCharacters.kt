fun main() {
//    val d = "abcabcbb"  //op = 3
    val d = "abcdefghijk"
//    lengthOfLongestSubstring(d) // optimized
    val l =d.length
    var r = 0
    for(i in 0..<l){
        for( j in i..<l){
            r = r.coerceAtLeast(isDistinct(d, i, j))
        }
    }
    println(r)
}

fun isDistinct(d:String, i:Int, j :Int):Int{
    val hm = mutableListOf<Char>()
    for (e in i .. j){
        if(hm.contains(d[e])){
            return 0
        }
        hm.add(d[e])
    }
    return hm.size
}
fun lengthOfLongestSubstring(s: String): Int {
    //optimized with less TC(time complexity) = O(n)
    var start = 0
    // Result
    var max = 0
    // Occurrence map
    val occ = mutableMapOf<Char, Int>()

    for ((i, c) in s.withIndex()) {

        if (occ.containsKey(c)) {
            // Found a clash, move the start pointer
            // next to the previous occurance if applicable
            val seekPoint = occ[c]!! + 1
            start = Math.max(seekPoint, start)
        }

        val length = i - start + 1
        max = Math.max(length, max)

        // Update the map with latest occurance
        // when clash happen next time, use this index
        occ[c] = i
    }
    return max
}
