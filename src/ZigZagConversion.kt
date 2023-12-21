fun main() {
    println(convert("PAYPALISHIRING", 4))
//    println(convert2("PAYPALISHIRING", 4)) optimized
    println("PINALSIGYAHRPI")// output
}

fun convert(s: String, numRows: Int): String {
    if (numRows <= 1) {
        return s
    }
    val mainList = mutableListOf<String>()
    for (i in 0..<numRows) {
        mainList.add("")
    }
    var index = 0
    var up = false
    for (i in s.indices) {
        mainList[index] = mainList[index] + s[i]


        if (index == numRows - 1 && !up) {
            up = true
        }
        if (index == 0 && up) {
            up = false
        }
        if (up) {
            index--
        } else {
            index++
        }
    }
    return mainList.joinToString("")
}

fun convert2(s: String, numRows: Int): String {
    if(s.length == 1 || numRows == 1) return s
    val shift = (numRows - 1) * 2
    val sb = StringBuilder()

    for(r in 0 until numRows) {
        var i = r
        while(i < s.length) {
            sb.append(s[i])
            if(r != 0 && r != numRows - 1) {
                val j = i + (shift - 2 * r)
                if(j < s.length) {
                    sb.append(s[j])
                }
            }
            i += shift
        }
    }

    return sb.toString()
}