package ds.lists;

/*ircular linked list  - all nodes are connected to form a circle.
There is no NULL at the end.
 */

public class CircularLinkedList {
    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    CircularLinkedList() {
        head = null;
    }

    public static void main (String[] args) {
        CircularLinkedList clist = new CircularLinkedList();

        clist.addNode(13);
        clist.addNode(7);
        clist.addNode(24);
        clist.deleteNode(7);
    }

    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null)
            head = newNode;
        else
            tail.next = newNode;

        tail = newNode;
        tail.next = head;
    }

    public void deleteNode(int valueToDelete) {
        Node currentNode = head;
        if (head == null) // the list is empty
            return;

        do {
            Node nextNode = currentNode.next;
            if (nextNode.data == valueToDelete) {
                if (tail == head) { // the list has only one single element
                    head = null;
                    tail = null;
                } else {
                    currentNode.next = nextNode.next;
                    if (head == nextNode) //we're deleting the head
                        head = head.next;

                    if (tail == nextNode) //we're deleting the tail
                        tail = currentNode;
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }

}
