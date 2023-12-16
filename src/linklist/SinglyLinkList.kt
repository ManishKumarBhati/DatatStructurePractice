package linklist

class SinglyLinkedList {
    private var head: Node? = null
    private var tail: Node? = null
    private var size: Int = 0

    fun createSinglyLinkedList(nodeValue: Int): Node? {
        val node = Node(next = null, value = nodeValue)
        head = node
        tail = node
        size = 1
        return head
    }

    // Insert Method SinglyLinkedList
    fun add(nodeValue: Int, location: Int) {
        val node = Node(nodeValue)
        if (head == null) {
            createSinglyLinkedList(nodeValue)
            return
        } else if (location == 0) {
            node.next = head
            head = node
        } else if (location >= size) {
            node.next = null
            tail?.next = node
            tail = node
        } else {
            var tempNode: Node? = head
            var index = 0
            while (index < location - 1) {
                tempNode = tempNode?.next
                index++
            }
            val nextNode: Node? = tempNode?.next
            tempNode?.next = node
            node.next = nextNode
        }
        size++
    }

    // SinglyLinkedList Traversal
    fun printSLL() {
        if (head == null) {
            println("SLL does not exist!")
        } else {
            var tempNode: Node? = head
            for (i in 0..<size) {
                print(tempNode?.value)
                if (i != size - 1) {
                    print(" -> ")
                }
                tempNode = tempNode?.next
            }
        }
        println("\n")
    }

    // Search for a node
    fun searchNodeValue(nodeValue: Int): Boolean {
        if (head != null) {
            var tempNode: Node? = head
            for (i in 0..<size) {
                if (tempNode?.value == nodeValue) {
                    print("Found the node at location: $i\n")
                    return true
                }
                tempNode = tempNode?.next
            }
        }
        print("Node not found! ")
        return false
    }

    //Deleting a node from SinglyLinkedList
    fun deleteNodePosition(location: Int) {
        if (head == null) {
            println("The SLL does not exist")
            return
        } else if (location == 0) {
            head = head?.next
            size--
            if (size == 0) {
                tail = null
            }
        } else if (location >= size) {
            var tempNode: Node? = head
            for (i in 0..<size - 1) {
                tempNode = tempNode?.next
            }
            if (tempNode == head) {
                head = null
                tail = null
                size--
                return
            }
            tempNode?.next = null
            tail = tempNode
            size--
        } else {
            var tempNode: Node? = head
            for (i in 0..<location - 1) {
                tempNode = tempNode?.next
            }
            tempNode?.next = tempNode?.next?.next
            size--
        }
    }

    //  Delete Entire SinglyLinkedList
    fun deleteAll() {
        head = null
        tail = null
        println("The SLL deleted successfully")
    }
}