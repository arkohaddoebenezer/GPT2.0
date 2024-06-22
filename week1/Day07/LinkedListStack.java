public class LinkedListStack {
    private Node top;

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
    public LinkedListStack() {
        top = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            int value = top.value;
            top = top.next;
            return value;
        }
    }

    
    public boolean isEmpty() {
        return (top == null);
    }

}
