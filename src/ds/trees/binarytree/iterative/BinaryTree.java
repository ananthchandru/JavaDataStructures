package ds.trees.binarytree.iterative;

import ds.trees.Node;

import java.util.*;

public class BinaryTree {

    private Node root;

    BinaryTree() {
        root = null;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50, 60, 70};
        BinaryTree btq = new BinaryTree();

        for (int i : arr)
            btq.insertValue(i);

//        List<Node> preOrderList = btq.preOrder(btq.root, new LinkedList<Node>());
//        btq.printList(preOrderList);
//        List<Node> postOrderList = btq.postOrder(btq.root, new LinkedList<Node>());
//        btq.printList(postOrderList);
//        List<Node> inOrderList = btq.inOrder(btq.root, new LinkedList<Node>());
//        btq.printList(inOrderList);
        List<Node> levelOrderList = btq.levelOrder(btq.root, new LinkedList<Node>());
        System.out.println("\nPrinting Level order :\n");
        btq.printList(levelOrderList);
    }

    private Queue<Node> queue = new LinkedList<Node>();

    void insertValue(int value) {
        Node node = new Node(value);

        //if root is null
        if (root == null)
            root = node;
            // The left child of the current Node is used if it is available.
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

    //Non recursive level order using Queue
    List<Node> levelOrder(Node node, LinkedList<Node> list) {
        if (node == null)
            return list;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty())  {
            Node removedNode = queue.remove();
            //Add to output list or print
            list.add(removedNode);
            System.out.print(removedNode.data +  " ");

            if (removedNode.left != null)
                queue.add(removedNode.left);
            if (removedNode.right != null)
                queue.add(removedNode.right);
        }
        return list;
    }

    /* Non-recursive pre-order using Stack */

    public List<Node> preOrder2() {
        List<Node> preOrderList = new LinkedList<Node>();
        Stack<Node> nodeStack = new Stack<Node>();
        nodeStack.push(this.root);

        while (!nodeStack.empty()) {
            Node n = nodeStack.pop();
            preOrderList.add(n);
            if (n.right != null) nodeStack.push(n.right);
            if (n.left != null) nodeStack.push(n.left);
        }
        return preOrderList;
    }

    public void printList(List<Node> nodes) {
        for(Node n : nodes)
            System.out.print(n.data + ",");
    }
}
