public class ArrayStack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor
    public ArrayStack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    // Push method
    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full.");
        } else {
            stackArray[++top] = value;
        }
    }

    // Pop method
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }
    
    // Peek method to view the top element
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return stackArray[top];
        }
    }
}
