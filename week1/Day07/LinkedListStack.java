public class LinkedListStack {
    private Node top;

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
    public LinkedListStack() {
        top = null;
    }

    // Push method
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    // Pop method
    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            int value = top.data;
            top = top.next;
            return value;
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == null);
    }

    // Peek method to view the top element
    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return top.data;
        }
    }
}
