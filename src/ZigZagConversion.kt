fun main() {
    println(convert("PAYPALISHIRING", 4))
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