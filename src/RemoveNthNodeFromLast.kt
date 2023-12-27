/*
Remove Nth Node From End of List
Given the head of a linked list, remove the nth node from the end of the list and return its head.



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

*/


fun main() {
    val ll = ListNode(2, ListNode(4, ListNode(3)))
    val l2 = ListNode(5, ListNode(6))

    (removeNthFromEnd(ll, 1))
//    println(removeNthFromEnd(ll, 1))
//    println(foldTet())
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null) return null
    var i = 0
    var tempNode = head
    while (tempNode != null) {
        tempNode = tempNode.next
        i++
    }
    if (n >= i) return head.next

    tempNode = head
    for (j in 0..<i - n - 1) {
        tempNode = tempNode?.next
    }
    tempNode?.next = tempNode?.next?.next
    return head
}

