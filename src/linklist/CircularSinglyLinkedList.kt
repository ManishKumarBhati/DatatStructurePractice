package linklist

class CircularSinglyLinkedList {
    var head: Node? = null
    var tail: Node? = null
    var size: Int = 0

    fun create(nodeValue: Int): Node? {
        head = Node(nodeValue)
        val node = Node(nodeValue)
        node.next = node
        head = node
        tail = node
        size = 1
        return head
    }

    //  Insertion Method
    fun add(nodeValue: Int, location: Int) {
        val node = Node(nodeValue)
        if (head == null) {
            create(nodeValue)
            return
        } else if (location == 0) {
            node.next = head
            head = node
            tail?.next = head
        } else if (location >= size) {
            tail?.next = node
            tail = node
            tail?.next = head
        } else {
            var tempNode = head
            var index = 0
            while (index < location - 1) {
                tempNode = tempNode?.next
                index++
            }
            node.next = tempNode?.next
            tempNode?.next = node
        }
        size++
    }

    // Traversal Method
    fun printCSLL() {
        if (head != null) {
            var tempNode = head
            for (i in 0..<size) {
                print(tempNode?.value)
                if (i != size - 1) {
                    print(" -> ")
                }
                tempNode = tempNode?.next
            }
            println("\n")
        } else {
            println("\nCSLL does not exist!")
        }
    }

    // Search Method
    fun searchNode(nodeValue: Int): Boolean {
        if (head != null) {
            var tempNode = head
            for (i in 0..<size) {
                if (tempNode?.value == nodeValue) {
                    print("Found node at location: $i")
                    return true
                }
                tempNode = tempNode?.next
            }
        }
        println("Node not found! ")
        return false
    }

    // Delete Method
    fun deleteNode(location: Int) {
        if (head == null) {
            println("The CSLL does not exist! ")
            return
        } else if (location == 0) {
            head = head?.next
            tail?.next = head
            size--
            if (size == 0) {
                tail = null
                head?.next = null
                head = null
            }
        } else if (location >= size) {
            var tempNode = head
            for (i in 0..<size - 1) {
                tempNode = tempNode?.next
            }
            if (tempNode === head) {
                head?.next = null
                head = null
                tail = head
                size--
                return
            }
            tempNode?.next = head
            tail = tempNode
            size--
        } else {
            var tempNode = head
            for (i in 0..<location - 1) {
                tempNode = tempNode?.next
            }
            tempNode?.next = tempNode?.next?.next
            size--
        }
    }

    // Delete CSLL
    fun deleteAll() {
        if (head == null) {
            println("The CSLL does not exist!")
        } else {
            head = null
            tail?.next = null
            tail = null
            println("The CSLL has been deleted!")
        }
    }
}