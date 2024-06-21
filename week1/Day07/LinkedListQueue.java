public class LinkedListQueue {
    private Node front;
    private Node rear;

    // Inner Node class
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor
    public LinkedListQueue() {
        front = null;
        rear = null;
    }

    // Enqueue method
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Dequeue method
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        } else {
            int value = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return value;
        }
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (front == null);
    }

    // Peek method to view the front element
    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        } else {
            return front.data;
        }
    }
}
