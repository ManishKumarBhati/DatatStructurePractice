package linklist

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        SinglyLinkedList().apply {
            createSinglyLinkedList(5)
            add(6, 1)
            add(7, 3)
            add(8, 4)
            add(9, 0)
            printSLL()
            searchNodeValue(6)
            deleteNodePosition(2)
            printSLL()
            deleteAll()
        }

        CircularSinglyLinkedList().apply {
            create(5)
            add(4, 0)
            add(6, 1)
            add(7, 8)
            printCSLL()
            deleteNode(1)
            printCSLL()
            searchNode(5)
            deleteAll()
            printCSLL()
        }
    }
}