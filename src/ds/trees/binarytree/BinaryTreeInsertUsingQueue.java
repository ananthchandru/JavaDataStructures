package ds.trees.binarytree;

import ds.trees.Node;
import java.util.*;

class BinaryTreeInsertUsingQueue{

    private Node root;

    BinaryTreeInsertUsingQueue() {
        root = null;
    }

    private Queue<Node> queue = new LinkedList<Node>();

    void insertValue(int value) {
        Node node = new Node(value);

        //if root is null
        if (root == null)
            root = node;
        // The left child of the current Node is used f it is available.
        else if (queue.peek().left == null) {
            queue.peek().left = node;
            // The right child of the current Node is used if it is available.
            // Since the left child of this node has already been used, the Node is popped from the queue
            // after using its right child.
        } else {
            queue.peek().right = node;
            queue.remove();
        }
        // Whenever a new Node is added to the tree, its address is pushed into the queue.
        // So that its children Nodes can be used later.
        queue.add(node);
    }

    void levelOrder(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())  {
            System.out.print(queue.peek().data +  " ");
            if (queue.peek().left != null)
                queue.add(queue.peek().left);
            if (queue.peek().right != null)
                queue.add(queue.peek().right);
            queue.remove();
        }
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50, 60, 70};
        BinaryTreeInsertUsingQueue btq = new BinaryTreeInsertUsingQueue();

        for (int i : arr)
            btq.insertValue(i);

        btq.levelOrder(btq.root);
    }
}
