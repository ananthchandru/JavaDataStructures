package ds.trees.binarytree.recursion;

import ds.trees.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import static java.lang.Math.max;

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

    public void insert(Node newNode) {
        if (this.root == null) {
            this.root = newNode;
        } else if (this.root.left == null) {
            this.root.left = newNode;
        } else if (this.root.right == null) {
            this.root.right = newNode;;
        } else {
            List<Node> siblingNodes = new LinkedList<Node>();
            siblingNodes.add(this.root.left);
            siblingNodes.add(this.root.right);
            insert2(siblingNodes, newNode);
        }
    }

    /* Check a level sibling nodes, find the node which doesn't have left or right child,
        then insert the new node */
    private void insert2(List<Node> siblingNodes, Node newNode) {
        List<Node> nextSiblingNodes = new LinkedList<Node>();
        for (Node currentNode : siblingNodes) {
            if (currentNode.left == null) {
                currentNode.left = newNode;
                return;
            } else if (currentNode.right == null) {
                currentNode.right = newNode;
                return;
            }
            nextSiblingNodes.add(currentNode.left);
            nextSiblingNodes.add(currentNode.right);
        }
        insert2(nextSiblingNodes, newNode);
    }

    /* Depth First search PreOrder Traversal */

    public List<Node> preOrder() {
        return preOrder(this.root, new LinkedList<Node>());
    }

    /* Pre-order tree traversal */
    private List<Node> preOrder(Node currentNode, List<Node>preOrderList) {
        preOrderList.add(currentNode);

        if (currentNode.left != null)
            preOrder(currentNode.left, preOrderList);

        if (currentNode.right != null)
            preOrder(currentNode.right, preOrderList);

        return preOrderList;
    }

    /* Deep first search in-oder tree traversal */
    public List<Node> inOrder() {
        return inOrder(this.root, new LinkedList<Node>());
    }

    /* In-order tree traversal */
    private List<Node> inOrder(Node currentNode, List<Node>inOrderList) {
        if (currentNode.left != null)
            inOrder(currentNode.left, inOrderList);

        inOrderList.add(currentNode);

        if (currentNode.right != null)
            inOrder(currentNode.right, inOrderList);

        return inOrderList;
    }

    /* Deep first search post-oder tree traversal */
    public List<Node> postOrder() {
        return postOrder(this.root, new LinkedList<Node>());
    }

    /* Post-order tree traversal */
    private List<Node> postOrder(Node currentNode, List<Node>postOrderList) {
        if (currentNode.left != null)
            postOrder(currentNode.left, postOrderList);

        if (currentNode.right != null)
            postOrder(currentNode.right, postOrderList);

        postOrderList.add(currentNode);
        return postOrderList;
    }

    int height(Node root)  {
        if (root == null)
            return 0;
        else {
            /* compute height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            return max(lheight, rheight)+1;
        }
    }

    public List<Node> levelOrder() {
        int height = height(this.root);
        LinkedList<Node> levelOrderList = new LinkedList<Node>();
        for (int i = 1; i <= height; i++)
            levelOrder(root, i, levelOrderList);
        return levelOrderList;
    }

    public List<Node> levelOrder(Node root, int level, LinkedList<Node> levelOrderList) {
        if (root == null)
            return levelOrderList;
        if (level == 1) {
            levelOrderList.add(root);
        } else if (level > 1) {
            levelOrder(root.left, level - 1, levelOrderList);
            levelOrder(root.right, level - 1, levelOrderList);
        }
        return levelOrderList;
    }

    public static void main(String[] args) {
        BinaryTree br = new BinaryTree();
        br.insert(new Node(5));
        br.insert(new Node(6));
        br.insert(new Node(1));
        br.insert(new Node(4));
        br.insert(new Node(3));
        br.insert(new Node(9));
        br.insert(new Node(2));
        br.insert(new Node(8));
        List<Node> preOrderList = br.preOrder();
        br.printList(preOrderList);
        List<Node> postOrderList = br.postOrder();
        br.printList(postOrderList);
        List<Node> inOrderList = br.inOrder();
        br.printList(inOrderList);
        List<Node> levelOrderList = br.levelOrder();
        br.printList(levelOrderList);
    }

    public void printList(List<Node> nodes) {
        System.out.println();
        for(Node n : nodes)
            System.out.print(n.data + ",");
    }
}
