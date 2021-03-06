package ds.trees.binarytree.iterative;


import ds.trees.Node;
import ds.trees.binarytree.iterative.BinaryTree;

import java.util.*;

/*
                 2
             7        5
         2       6         9
              5      11  4

(11,4 are in same point in distance, so during a bottom view, 4 precedes 11)
*/
//left View (2,7,2,5)

// Iterative
public class ViewsOfBinaryTree {

    static class Pair {
        int level;
        Node node;

        public Pair(int level, Node node) {
            this.level = level;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        BinaryTree br = new BinaryTree();
        br.setRoot(new Node(2));
        br.getRoot().left = new Node(7);
        br.getRoot().left.left = new Node(2);
        br.getRoot().left.right = new Node(6);
        br.getRoot().left.right.left = new Node(5);
        br.getRoot().left.right.right = new Node(11);

        br.getRoot().right = new Node(5);
        br.getRoot().right.right = new Node(9);
        br.getRoot().right.right.left = new Node(4);

        ViewsOfBinaryTree view = new ViewsOfBinaryTree();

        System.out.println();

        LinkedList<Node> leftViewList = new LinkedList<Node>();
        System.out.println("Print Left View Iterative: ");
        view.leftViewIterative(br.getRoot(), 1, leftViewList);

        br.printList(leftViewList);

        System.out.println();

        LinkedList<Node> rightViewList = new LinkedList<Node>();
        System.out.println("Print Right View Iterative: ");
        view.rightViewIterative(br.getRoot(), 1, rightViewList);

        br.printList(rightViewList);

        System.out.println();

        TreeMap<Integer, Integer> topViewMap = new TreeMap<>();
        System.out.println("Print Top View : ");
        view.topViewIterative(br.getRoot(), topViewMap);
        for (Map.Entry<Integer, Integer> entry : topViewMap.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }

        System.out.println();

        TreeMap<Integer, Integer> bottomViewMap = new TreeMap<>();
        System.out.println("Print Bottom View: ");
        view.bottomViewIterative(br.getRoot(), bottomViewMap);
        for (Map.Entry<Integer, Integer> entry : bottomViewMap.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    public void leftViewIterative(Node node, int level, LinkedList<Node> list) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for(int i=1; i<=queueSize; i++) {
                Node removedNode = queue.poll();
                if(i==1)
                    list.add(removedNode);
                if (removedNode.left != null)
                    queue.add(removedNode.left);
                if (removedNode.right != null)
                    queue.add(removedNode.right);
            }
        }
    }

    public void rightViewIterative(Node node, int level, LinkedList<Node> list) {
        if(node == null)
            return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for(int i=1; i<=queueSize; i++) {
                Node removedNode = queue.poll();
                if(i==queueSize)
                    list.add(removedNode);
                if (removedNode.left != null)
                    queue.add(removedNode.left);
                if (removedNode.right != null)
                    queue.add(removedNode.right);
            }
        }
    }

   public void topViewIterative(Node node, TreeMap<Integer, Integer> map) {
        if(node == null)
            return;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(0, node));

        while(!queue.isEmpty()) {
            Pair removedNode = queue.poll();
            map.putIfAbsent(removedNode.level, removedNode.node.data);
            if(removedNode.node.left !=null)
                queue.add(new Pair(removedNode.level-1, removedNode.node.left));
            if(removedNode.node.right !=null)
                queue.add(new Pair(removedNode.level+1, removedNode.node.right));
        }
    }

    public void bottomViewIterative(Node node, TreeMap<Integer, Integer> map) {
        if(node == null)
            return;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(0, node));

        while(!queue.isEmpty()) {
            Pair removedNode = queue.poll();
            map.put(removedNode.level, removedNode.node.data);
            if(removedNode.node.left !=null)
                queue.add(new Pair(removedNode.level-1, removedNode.node.left));
            if(removedNode.node.right !=null)
                queue.add(new Pair(removedNode.level+1, removedNode.node.right));
        }
    }
}