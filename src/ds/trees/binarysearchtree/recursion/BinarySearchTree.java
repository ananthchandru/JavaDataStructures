package ds.trees.binarysearchtree.recursion;

import ds.trees.Node;

//InOrder - Left, Root, Right (Root in between left and right)
//PreOrder - Root, Left, Right (Root before left, right)
//PostOrder - Left, Right, Root (Root after left, right)

class BinarySearchTree {

    private Node root;

    BinarySearchTree() {
        root = null;
    }

    // This method mainly calls deleteRec()
    void deletedata(int data) {
        root = deleteRec(root, data);
    }

    /* A recursive function to delete an existing data in BST
     */
    Node deleteRec(Node root, int data) {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (data < root.data)
            root.left = deleteRec(root.left, data);
        else if (data > root.data)
            root.right = deleteRec(root.right, data);
            // if data is same as root's data, then this is the node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    // This method mainly calls insertRec()
    void insert(int data) {
        root = insertRec(root, data);
    }

    /* A recursive function to insert a new data in BST */
    Node insertRec(Node root, int data) {
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(data);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() {
        inorderTraversal(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    // This method mainly calls preorderRec()
    void preorder() {
        preOrderTraversal(root);
    }

    // A utility function to do preorder traversal of BST
    void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    // This method mainly calls postorderRec()
    void postorder() {
        postOrderTraversal(root);
    }

    // A utility function to do postorder traversal of BST
    void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();
	     /* Let us create following BST
	           50
	        /     \
	       30      70
	      /  \    /  \
	     20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.deletedata(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.deletedata(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.deletedata(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
        System.out.println("\nPreorder traversal of the modified tree");
        tree.preorder();
        System.out.println("\nPostorder traversal of the modified tree");
        tree.postorder();
    }
}

