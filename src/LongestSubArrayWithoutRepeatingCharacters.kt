fun main() {
//    val d = "abcabcbb"  //op = 3
    val d = "abcdefghijk"
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