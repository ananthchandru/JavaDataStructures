package ds.lists;

/* Linked List has
    i) head (1st node)
    ii) next (pointer to subsequent nodes)
    iii) next of last node is null
 */

public class LinkedList {

    private Node head;

    public Node getHead() {
        return head;
    }

    LinkedList() {
        head = null;
    }

    public static void main (String[] args) {
        LinkedList list = new LinkedList();
        LinkedList llist = new LinkedList();

        llist.insertAtEnd(1);
        llist.insertAtBeginning(2);
        llist.insertAtBeginning(3);
        llist.insertAtEnd(4);
        llist.insertAfter(llist.head.next, 5);

        System.out.println("Linked list: ");
        llist.printList();

        System.out.println("\nAfter deleting an element: ");
        llist.deleteKey(3); //if  null is returned, it means key not found

        System.out.println();
        int item_to_find = 3;
        if (llist.search(llist.head, item_to_find))
            System.out.println(item_to_find + " is found");
        else
            System.out.println(item_to_find + " is not found");

        llist.sortLinkedList(llist.head);
        System.out.println("\nSorted List: ");
        llist.printList();
    }

    // Insert after a node
    public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head; //head would be null on 1st insert
        head = newNode;
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = new Node(data);
            return;
        }
        newNode.next = null;

        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = newNode;
        return;
    }

    //Delete first occurrence of a key
    public boolean deleteKey(int key) {
        Node current = head;
        Node prev = null;

        // 1. if head is the key
        if(current!=null && current.data == key) {
            head = head.next;
            return true;
        }
        // 2. till item found, current = current.next, previous = current
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }
        //Key not found
        if(current == null)
            return false;
        // Key found
        prev.next = current.next;
        return true;
    }

    // Delete node at position
    public void deleteKeyAtPosition(int position) {

        // 1. Empty list
        if (head == null)
            return;

        Node temp = head;

        // 1. If head needs to be removed
        if (position == 0) {
            head = temp.next;
            return;
        }
        //2. Find the key to be deleted
        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;

        //3. If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;

        //4. Key found
        Node next = temp.next.next;
        temp.next = next;
    }

    //Search
    boolean search(Node head, int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key)
                return true;
            current = current.next;
        }
        return false;
    }

    // Sort the linked list (much like bubble sort)
    void sortLinkedList(Node head) {
        Node current = head;
        Node index = null;
        int temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                // index points to the node next to current
                index = current.next;

                while (index != null) {
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
