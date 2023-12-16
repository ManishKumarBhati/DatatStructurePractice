data class ListNode(val `val`: Int, var next: ListNode? = null)

fun main() {
    val ll = ListNode(2, ListNode(4, ListNode(3)))
    val l2 = ListNode(5, ListNode(6))

    println(addTwoNumbers(ll, l2))
}

fun addTwoNumbers(ln1: ListNode?, ln2: ListNode?): ListNode? {
    var l1 = ln1
    var l2 = ln2
    val dummy = ListNode(0)
    var l3 = dummy
    var carry = 0
    while (l1 != null || l2 != null) {
        val first = l1?.`val` ?: 0
        val second = l2?.`val` ?: 0
        val sum = first + second + carry
        carry = sum / 10
        val mod = sum % 10
        val node = ListNode(mod)
        l3.next = node
        if (l1 != null) l1 = l1.next
        if (l2 != null) l2 = l2.next
        l3 = l3.next!!
        if (carry > 0) {
            val ln = ListNode(carry)
            l3.next = ln
        }
    }
    return dummy.next

}