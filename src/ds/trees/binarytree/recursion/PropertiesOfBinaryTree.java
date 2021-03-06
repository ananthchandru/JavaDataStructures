package ds.trees.binarytree.recursion;

import ds.trees.Node;

import java.util.List;

import static java.lang.Math.max;

public class PropertiesOfBinaryTree {

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

        PropertiesOfBinaryTree props = new PropertiesOfBinaryTree();
        //printing for reference
        System.out.println("Level Order Traversal : ");
        List<Node> levelOrderList = br.levelOrder();
        br.printList(levelOrderList);

        System.out.println();

        int heightOfTree = props.height(br.getRoot());
        System.out.println("Height of tree: " + heightOfTree);

        int numberOfNodes = props.numberOfNodes(br.getRoot());
        System.out.println("No. of nodes: " + numberOfNodes);

        int sumOfNodes = props.sumOfNodes(br.getRoot());
        System.out.println("Sum of nodes: " + sumOfNodes);

        int leafNodes = props.leafNodes(br.getRoot());
        System.out.println("Number of leaf nodes: " + leafNodes);

        int evenOddLevelDiff = props.evenOddLevelDiff(br.getRoot());
        System.out.println("Difference between even and odd level: " + evenOddLevelDiff);

        System.out.println("Print Elements At Given Level: " );
        props.printElementsAtGivenLevel(br.getRoot(), 2);

        System.out.println();
        System.out.println("Print Elements At Given Level: " );
        props.printElementsAtGivenLevel(br.getRoot(), 3);

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

    public int numberOfNodes(Node node) {
        if(node==null)
            return 0;
        return 1+ numberOfNodes(node.left) + numberOfNodes(node.right);
    }

    public int sumOfNodes(Node node) {
        if(node==null)
            return 0;
        return node.data + sumOfNodes(node.left) + sumOfNodes(node.right);
    }

    public int leafNodes(Node node) {
        if(node==null)
            return 0;
        if(node.left==null && node.right==null)
            return 1;
        return leafNodes(node.left) + leafNodes(node.right);
    }

    public int evenOddLevelDiff(Node node) {
        if(node==null)
            return 0;
        return node.data - evenOddLevelDiff(node.left) - evenOddLevelDiff(node.right);
    }

    public void printElementsAtGivenLevel(Node node, int level) {
        if(node == null)
            return;
        if(level==1) {
            System.out.print(node.data + " ");
            return;
        }

        printElementsAtGivenLevel(node.left, level-1);
        printElementsAtGivenLevel(node.right, level-1);
    }

}
