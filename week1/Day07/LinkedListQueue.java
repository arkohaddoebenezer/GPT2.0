public class LinkedListQueue {
    private Node front;
    private Node rear;

    // Inner Node class
    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

  
    public LinkedListQueue() {
        front = null;
        rear = null;
    }

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

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        } else {
            int value = front.value;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return value;
        }
    }

    public boolean isEmpty() {
        return (front == null);
    }

}
