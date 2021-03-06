package ds.trees.binarytree.iterative;

import ds.trees.Node;

import java.util.*;

/*
                  10
             20        30
          40   50    60   70

          preOrder => 10,20,40,50,30,60,70 (using stack)
          inOrder => 40,20,50,10,60,30,70 (using stack)
          postOrder => 40,50,20,60,70,30,10 (using 2 stack and one stack methodologies)
          levelOrder => 10,20,30,40,50,60,70 (using queue)
*/

public class BinaryTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    BinaryTree() {
        root = null;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50, 60, 70};
        BinaryTree btq = new BinaryTree();

        for (int i : arr)
            btq.insertValue(i);

        System.out.println("\nPrinting Pre order :");
        List<Node> preOrderList = btq.preOrder(btq.root);
        btq.printList(preOrderList);
        System.out.println("\nPrinting Post order :");
        List<Node> postOrderList = btq.postOrder(btq.root);
        btq.printList(postOrderList);
        System.out.println("\nPrinting InOrder :");
        List<Node> inOrderList = btq.inOrder(btq.root);
        btq.printList(inOrderList);
        System.out.println("\nPrinting Level order :");
        List<Node> levelOrderList = btq.levelOrder(btq.root);
        btq.printList(levelOrderList);
    }

    private Queue<Node> queue = new LinkedList<Node>();

    void insertValue(int value) {
        Node node = new Node(value);
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

    List<Node> inOrder(Node node) {
        List<Node> list = new LinkedList<Node>();
        Stack<Node> stack = new Stack<Node>();
        Node current = node;

        while(current != null || !stack.isEmpty()) {
            //Reach left most
            while(current!=null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current);
    //        System.out.print(current.data + " ");
            current = current.right;
        }
        return list;
    }

    /* Non-recursive pre-order using Stack */
    public List<Node> preOrder(Node node) {
        List<Node> list = new LinkedList<Node>();
        Stack<Node> nodeStack = new Stack<Node>();
        nodeStack.push(node);

        while (!nodeStack.empty()) {
            Node n = nodeStack.pop();
            list.add(n);
            if (n.right != null) nodeStack.push(n.right);
            if (n.left != null) nodeStack.push(n.left);
        }
        return list;
    }

    //Using 2 stacks
    /*public List<Node> postOrder(Node node) {
        List<Node> list = new LinkedList<Node>();
        Stack<Node> stackOne = new Stack<Node>();
        Stack<Node> stackTwo = new Stack<Node>();

        stackOne.push(node);
        while(!stackOne.isEmpty()) {
           Node removedNode = stackOne.pop();
            stackTwo.push(removedNode);
           if(removedNode.left != null)
                stackOne.push(removedNode.left);
           if(removedNode.right!=null)
                stackOne.push(removedNode.right);
        }

        while(!stackTwo.isEmpty()) {
            list.add(stackTwo.pop());
        }
        return list;
    }*/

    //Post order using single stack
    public List<Node> postOrder(Node node) {
        List<Node> list = new LinkedList<Node>();
        Stack<Node> stack = new Stack();
        /*
          1. Traverse from root to left most node
          2. Check if last node (which does not have left node) has right child
                if not pop it to output
          3. peek the stack and check if it has right child
                if yes, push it to the stack, make it current node
          3. Steps 1, 2, 3 again
         */
        Node current = node;
        while(current!=null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                Node temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    list.add(temp);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        list.add(temp);
                    }
                } else
                    current = temp;
            }
        }
        return list;
    }

    //Non recursive level order using Queue
    List<Node> levelOrder(Node node) {
        List<Node> list = new LinkedList<Node>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty())  {
            Node removedNode = queue.remove();
            //Add to output list or print
            list.add(removedNode);
    //        System.out.print(removedNode.data +  " ");

            if (removedNode.left != null)
                queue.add(removedNode.left);
            if (removedNode.right != null)
                queue.add(removedNode.right);
        }
        return list;
    }

    public void printList(List<Node> nodes) {
    //    System.out.println();
        for(Node n : nodes)
            System.out.print(n.data + ",");
    }
}
