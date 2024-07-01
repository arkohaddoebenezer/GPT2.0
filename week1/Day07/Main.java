public class Main {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);

        // ArrayStack arrayStack Usage
        System.out.println("pushed 10: ");
        arrayStack.push(10);
        System.out.println("pushed 20: ");
        arrayStack.push(20);
        System.out.println("pushed 30: ");
        arrayStack.push(30);

        System.out.println("pop removed: " + arrayStack.pop());

        // LinkedListStack Usage
        LinkedListStack linkedListStack = new LinkedListStack();
        
        System.out.println("pushed 10: ");
        linkedListStack.push(10);
        System.out.println("pushed 20: ");
        linkedListStack.push(20);
        System.out.println("pushed 30: ");
        linkedListStack.push(30);

        System.out.println("pop removed: " + linkedListStack.pop());


        // ArrayQueue Usage
        ArrayQueue arrayQueue = new ArrayQueue(5);

        System.out.println("enqueued 10: ");
        arrayQueue.enqueue(10);
        System.out.println("enqueued 20: ");
        arrayQueue.enqueue(20);
        System.out.println("enqueued 30: ");
        arrayQueue.enqueue(30);

        System.out.println(arrayQueue.dequeue());


        // LinkedListQueue Usage
        LinkedListQueue linkedListQueue = new LinkedListQueue();

        linkedListQueue.enqueue(10);
        linkedListQueue.enqueue(20);
        linkedListQueue.enqueue(30);

        System.out.println(linkedListQueue.dequeue());

        SortedLinkedList sortedLinkedList = new SortedLinkedList();
        sortedLinkedList.push(3);
        sortedLinkedList.push(1);
        sortedLinkedList.push(2);
        sortedLinkedList.push(4);
        sortedLinkedList.printList();
    }
}
