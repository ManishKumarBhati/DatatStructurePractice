/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.*/
fun main() {
    println(longestCommonPrefix(arrayOf("ab", "a", "")))
}

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    if (strs.size == 1 || strs.first().isBlank()) return strs.first()
    var smallestLength = strs[0].length
    strs.forEach {
        if (it.length < smallestLength) smallestLength = it.length
    }
    if (smallestLength<1) return ""
    var commonPrefix = strs[0][0].toString()
    var stop = false
    var i = 1
    var j = 1
    while (!stop && j<=smallestLength) {
        if (strs[i].isBlank()) {
            return ""
        }

        if (commonPrefix.length != j && i == 0) {
            commonPrefix = strs[i].substring(0, j)
        }

        if (commonPrefix != strs[i].substring(0, j)) {
            stop = true
            commonPrefix = commonPrefix.substring(0, j - 1)
        }
        if (i == strs.size - 1) {
            i = 0
            j++
        } else i++
    }

    return commonPrefix
}