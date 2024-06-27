
class SortedLinkedList {
    Node head;

    SortedLinkedList() {
        this.head = null;
    }

    void push(int value) {
        Node newNode = new Node(value);

        if (head == null || head.value >= newNode.value) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.value < newNode.value) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
 