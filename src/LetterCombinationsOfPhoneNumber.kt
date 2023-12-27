/*
Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.




Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]

*/


fun main() {
    println(letterCombinationss("236"))
//    println(foldTet())
}


fun letterCombinationss(digits: String): List<String> {
    return digits.takeIf { it.isNotEmpty() }?.fold(listOf("")) { acc, c ->
        c.letters().flatMap { letter -> acc.map { it + letter } }
    } ?: emptyList()
}

fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return emptyList()

    val numLIst = digits.toList()
    val two = listOf("a", "b", "c")
    val three = listOf("d", "e", "f")
    val four = listOf("g", "h", "i")
    val five = listOf("j", "k", "l")
    val six = listOf("m", "n", "o")
    val seven = listOf("p", "q", "r", "s")
    val eight = listOf("t", "u", "v")
    val nine = listOf("w", "x", "y", "z")


    val d = mutableMapOf(
        '2' to two,
        '3' to three,
        '4' to four,
        '5' to five,
        '6' to six,
        '7' to seven,
        '8' to eight,
        '9' to nine,

        )

    val e = numLIst.flatMap { c ->
        (d[c] ?: emptyList()).map {
            c.toString() + it
        }
    }

    return e
}

private fun Char.letters() =
    when (this) {
        '2' -> listOf('a', 'b', 'c')
        '3' -> listOf('d', 'e', 'f')
        '4' -> listOf('g', 'h', 'i')
        '5' -> listOf('j', 'k', 'l')
        '6' -> listOf('m', 'n', 'o')
        '7' -> listOf('p', 'q', 'r', 's')
        '8' -> listOf('t', 'u', 'v')
        '9' -> listOf('w', 'x', 'y', 'z')
        else -> listOf()

    }

fun letterCombinations2(digits: String): List<String> {
    val result = mutableListOf<String>()
    val letters = hashMapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz",
    )


    tailrec fun backtracking(str: String, curDig: String) {
        if (curDig.isEmpty()) {
            if (str.isNotEmpty()) {
                result.add(str)
            }
            return
        }
        letters[curDig.first()]?.forEach { letter ->
            backtracking(str + letter, curDig.substring(1, curDig.length))
        }
    }
    backtracking("", digits)
    return result
}
private val hash = HashMap<Char, String>().apply {
    put('2',"abc")
    put('3',"def")
    put('4',"ghi")
    put('5',"jkl")
    put('6',"mno")
    put('7',"qprs")
    put('8',"tuv")
    put('9',"wxyz")
}

fun letterCombinations3(digits: String): List<String> {

    if(digits.isEmpty()) return listOf()
    return getCombination(digits,"", 0)
}

fun getCombination(digit:String, intitalValue:String, digiIndex:Int) : List<String> {
    val value = hash.getValue(digit[digiIndex])
    val listResult = mutableListOf<String>()
    value.forEach {
        val combination = StringBuilder(intitalValue)
        combination.append(it)
        if(digiIndex == digit.lastIndex) {
            listResult.add(combination.toString())
        } else {
            listResult.addAll(getCombination(digit,combination.toString(),digiIndex+1))
        }
    }
    return listResult

}
