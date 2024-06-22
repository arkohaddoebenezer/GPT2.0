public class Main {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);

        System.out.println("pushed 10: ");
        arrayStack.push(10);
        System.out.println("pushed 20: ");
        arrayStack.push(20);
        System.out.println("pushed 30: ");
        arrayStack.push(30);

        System.out.println("pop removed: " + arrayStack.pop());



        LinkedListStack linkedListStack = new LinkedListStack();
        
        System.out.println("pushed 10: ");
        linkedListStack.push(10);
        System.out.println("pushed 20: ");
        linkedListStack.push(20);
        System.out.println("pushed 30: ");
        linkedListStack.push(30);

        System.out.println("pop removed: " + linkedListStack.pop());


        ArrayQueue arrayQueue = new ArrayQueue(5);

        System.out.println("enqueued 10: ");
        arrayQueue.enqueue(10);
        System.out.println("enqueued 20: ");
        arrayQueue.enqueue(20);
        System.out.println("enqueued 30: ");
        arrayQueue.enqueue(30);

        System.out.println(arrayQueue.dequeue());

        LinkedListQueue linkedListQueue = new LinkedListQueue();

        linkedListQueue.enqueue(10);
        linkedListQueue.enqueue(20);
        linkedListQueue.enqueue(30);

        System.out.println(linkedListQueue.dequeue());
    }
}
