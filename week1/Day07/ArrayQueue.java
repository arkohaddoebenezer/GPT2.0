public class ArrayQueue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    // Constructor
    public ArrayQueue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    // Enqueue method
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full.");
        } else {
            if (rear == maxSize - 1) {
                rear = -1; // Wrap around
            }
            queueArray[++rear] = value;
            nItems++;
        }
    }

    // Dequeue method
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        } else {
            int temp = queueArray[front++];
            if (front == maxSize) {
                front = 0; // Wrap around
            }
            nItems--;
            return temp;
        }
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (nItems == 0);
    }

    // Check if the queue is full
    public boolean isFull() {
        return (nItems == maxSize);
    }

    // Peek method to view the front element
    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        } else {
            return queueArray[front];
        }
    }
}
