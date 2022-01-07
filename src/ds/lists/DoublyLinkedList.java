package ds.lists;

/* Doubly Linked List can be traversed in both forward and backward direction
   It has head, next, prev
    i) head (1st node), prev of head is null
    ii) next (pointer to subsequent nodes)
    iii) next of last node is null
 */

public class DoublyLinkedList {
    Node head; 
    /* Doubly Linked list Node*/
    static class Node {
        int data;
        Node prev;
        Node next;

        // Constructor to create a new node

        Node(int d) {
            data = d;
            prev = next = null; //not required - next and prev is by default initialized as null
        }
    }

    public static void main(String[] args) {
        /* Start with the empty list */
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtEnd(6);
        dll.insertAtBeginning(7);
        dll.insertAtBeginning(1);
        dll.insertAtEnd(4);
        dll.insertAfter(dll.head.next, 8);
        dll.insertBefore(dll.head.next.next, 5);

        dll.deleteNode(dll.head.next.next.next);
        dll.deleteNodeAtGivenPos(3);

        System.out.println("Created DLL is: ");
        dll.printlist(dll.head);//traverse forward and reverse
    }

    // Adding a node at the front of the list
    public void insertAtBeginning(int data) {
        Node node = new Node(data);
        node.next = head;
        node.prev = null;

        if (head != null)
            head.prev = node;

        head = node;
    }

    // Adding a node at the end of the list
    void insertAtEnd(int data) {
        Node node = new Node(data);
        Node last = head;
        node.next = null;

        // 1. Empty Linked List
        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }

        // 2. Else traverse till the last node
        while (last.next != null)
            last = last.next;

        last.next = node;
        node.prev = last;
    }

    // Insert a node before the given node
    public void insertBefore(Node nextNode, int data) {
        if(nextNode == null) {
            System.out.println("The given next node can not be NULL");
            return;
        }
        
        Node node = new Node(data);
        node.prev = nextNode.prev;
        nextNode.prev = node;
        node.next = nextNode;

        //Check if new node is added as head
        if(node.prev != null)
            node.prev.next = node;
        else
            head = node;
    }

    /* Given a node as prevNode, insert a new node after the given node */
    public void insertAfter(Node prevNode, int data) {

        if (prevNode == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }

        Node node = new Node(data);
        node.next = prevNode.next;
        prevNode.next = node;
        node.prev = prevNode;

        if (node.next != null)
            node.next.prev = node;
    }

    public void deleteNode(Node node) {

        // 1. Base case
        if (head == null || node == null) {
            return;
        }

        // 2. If node to be deleted is head node
        if (head == node)
            head = node.next;

        // 3. Change next only if node to be deleted is NOT the last node
        if (node.next != null)
            node.next.prev = node.prev;

        // 4. Change prev only if node to be deleted is NOT the first node
        if (node.prev != null)
            node.prev.next = node.next;

        return;
    }

    void deleteNodeAtGivenPos(int n) {
        /* if list in NULL or invalid position is given */
        if (head == null || n <= 0)
            return;

        Node current = head;

        // traverse up to the node at position 'n' from the beginning
        for (int i = 1; current != null && i < n; i++)
            current = current.next;

        // if 'n' is greater than the number of nodes in the doubly linked list
        if (current == null)
            return;

        // delete the node pointed to by 'current'
        deleteNode(current);
    }

    public void printlist(Node node) {
        Node last = null;
        System.out.println("Traversal in forward Direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }

}
