public class Main {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);

        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);

        System.out.println(arrayStack.pop()); // Outputs: 30
        System.out.println(arrayStack.peek()); // Outputs: 20


        LinkedListStack linkedListStack = new LinkedListStack();

        linkedListStack.push(10);
        linkedListStack.push(20);
        linkedListStack.push(30);

        System.out.println(linkedListStack.pop()); // Outputs: 30
        System.out.println(linkedListStack.peek()); // Outputs: 20


        ArrayQueue arrayQueue = new ArrayQueue(5);

        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);

        System.out.println(arrayQueue.dequeue()); // Outputs: 10
        System.out.println(arrayQueue.peekFront()); // Outputs: 20


        LinkedListQueue linkedListQueue = new LinkedListQueue();

        linkedListQueue.enqueue(10);
        linkedListQueue.enqueue(20);
        linkedListQueue.enqueue(30);

        System.out.println(linkedListQueue.dequeue()); // Outputs: 10
        System.out.println(linkedListQueue.peekFront()); // Outputs: 20
    }
}
