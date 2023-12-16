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

fun addTwoNumbersV2(ln1: ListNode?, ln2: ListNode?): ListNode? {
    var head1 = ln1
    var head2 = ln2
    // Head of the new linked list - this is the head of the resultant list
    var head: ListNode? = null
    // Reference of head which is null at this point
    var temp: ListNode? = null
    // Carry
    var carry = 0
    // Loop for the two lists
    while (head1 != null || head2 != null) {
        // At the start of each iteration, we should add carry from the last iteration
        var sum = carry
        // Since the lengths of the lists may be unequal, we are checking if the
        // current node is null for one of the lists
        if (head1 != null) {
            sum += head1.`val`
            head1 = head1.next
        }
        if (head2 != null) {
            sum += head2.`val`
            head2 = head2.next
        }
        // At this point, we will add the total sum % 10 to the new node
        // in the resultant list
        val node = ListNode(sum % 10)
        // Carry to be added in the next iteration
        carry = sum / 10
        // If this is the first node or head
        if (temp == null) {
            head = node
            temp = head
        } else {
            temp.next = node
            temp = temp.next
        }
    }
    // After the last iteration, we will check if there is carry left
    // If it's left then we will create a new node and add it
    if (carry > 0) {
        temp!!.next = ListNode(carry)
    }
    return head

}