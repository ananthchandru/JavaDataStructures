package ds.queue;

public class QueueUsingLinkedList {

    QNode front, rear;

    public QueueUsingLinkedList() {
        this.front = this.rear = null;
    }

    public static void main(String[] args) {
        QueueUsingLinkedList q = new QueueUsingLinkedList();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.displayList();
        q.dequeue();
        q.displayList();
        System.out.println("Queue Front : " + q.front.key);
        System.out.println("Queue Rear : " + q.rear.key);
    }

    void enqueue(int key) {
        // Create a new LL node
        QNode temp = new QNode(key);

        // If queue is empty, then new node is front and rear both
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        this.rear.next = temp;
        this.rear = temp;
    }

    // Method to remove an key from queue.
    void dequeue() {
        // If queue is empty, return NULL.
        if (this.front == null)
            return;

        // Store previous front and move front one node ahead
        QNode temp = this.front;
        this.front = this.front.next;

        // If front becomes NULL, then change rear also as NULL
        if (this.front == null)
            this.rear = null;
    }

    public void displayList() {
        QNode current = front;
        // loop till last node
        while (current != null) {
            System.out.print("\t" + current.key);
            current = current.next;
        }
        System.out.println();
    }
}
