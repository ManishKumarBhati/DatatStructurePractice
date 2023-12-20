package linklist

class DoublyLinkedList {
    var head: DoubleNodes? = null
    var tail: DoubleNodes? = null
    var size: Int = 0

    fun create(nodeValue: Int): DoubleNodes? {
        val newNode = DoubleNodes(nodeValue)
        head = newNode
        tail = newNode
        size = 1
        return head
    }

    fun add(nodeValue: Int, location: Int) {
        val newNode = DoubleNodes(nodeValue)
        newNode.value = nodeValue
        if (head == null) {
            create(nodeValue)
            return
        } else if (location == 0) {
            newNode.next = head
            newNode.previous = null
            head?.previous = newNode
            head = newNode
        } else if (location >= size) {
            newNode.next = null
            tail?.next = newNode
            newNode.previous = tail
            tail = newNode
        } else {
            var tempNode = head
            var index = 0
            while (index < location - 1) {
                tempNode = tempNode?.next
                index++
            }
            newNode.previous = tempNode
            newNode.next = tempNode?.next
            tempNode?.next = newNode
            newNode.next?.previous = newNode
        }
        size++
    }

    fun printAll() {
        if (head != null) {
            var tempNode= head
            for (i in 0..<size) {
                print(tempNode?.value)
                if (i != size - 1) {
                    print(" -> ")
                }
                tempNode = tempNode?.next
            }
        } else {
            println("The DLL does not exist!")
        }
        println("\n")
    }

    fun printAllReverse() {
        if (head != null) {
            var tempNode = tail
            for (i in 0..<size) {
                print(tempNode?.value)
                if (i != size - 1) {
                    print(" <- ")
                }
                tempNode = tempNode?.previous
            }
        } else {
            println("The DLL does not exist!")
        }
        println("\n")
    }

    fun searchNode(nodeValue: Int): Boolean {
        if (head != null) {
            var tempNode= head
            for (i in 0..<size) {
                if (tempNode?.value == nodeValue) {
                    print("The Node is found at location: $i")
                    return true
                }
                tempNode = tempNode?.next
            }
        }
        print("Node not found!")
        return false
    }

    fun deletePos(location: Int) {
        if (head == null) {
            println("The DLL does not exist!")
            return
        } else if (location == 0) {
            if (size == 1) {
                head = null
                tail = null
                size--
                return
            } else {
                head = head?.next
                head?.previous = null
                size--
            }
        } else if (location >= size) {
            val tempNode= tail?.previous
            if (size == 1) {
                head = null
                tail = null
                size--
                return
            } else {
                tempNode?.next = null
                tail = tempNode
                size--
            }
        } else {
            var tempNode= head
            for (i in 0..<location - 1) {
                tempNode = tempNode?.next
            }
            tempNode?.next = tempNode?.next?.next
            tempNode?.next?.previous = tempNode
            size--
        }
    }

    fun deleteAll() {
        var tempNode: DoubleNodes? = head
        for (i in 0 until size) {
            tempNode?.previous = null
            tempNode = tempNode?.next
        }
        head = null
        tail = null
        println("The DLL has been deleted!")
    }
}