package ds.trees.binarytree.recursion;

import ds.trees.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
                 2
             7        5
         2       6         9
              5      11  4

(11,4 are in same point in distance, so during a bottom view, 4 precedes 11)
*/
//left View (2,7,2,5)

public class ViewsOfBinaryTree {

    static class Pair {
        int level, data;
        public Pair(int level, int data) {
            this.level = level;
            this.data = data;
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

        System.out.println("Print Left View: ");
        view.leftView(br.getRoot(), 0);

        System.out.println();

        System.out.println("Print Right View: ");
        view.rightView(br.getRoot(), 0);

        System.out.println();

        Map<Integer, Integer> leftViewMap = new HashMap<>();
        System.out.println("Print Left View Using map: ");
        view.leftViewUsingMap(br.getRoot(), 1, leftViewMap);

        for (int i = 1; i <= leftViewMap.size(); i++) {
            System.out.print(leftViewMap.get(i) + " ");
        }

        System.out.println();
        Map<Integer, Integer> rightViewMap = new HashMap<>();
        System.out.println("Print Right View Using map: ");
        view.rightViewUsingMap(br.getRoot(), 1, rightViewMap);

        for (int i = 1; i <= rightViewMap.size(); i++) {
            System.out.print(rightViewMap.get(i) + " ");
        }

        System.out.println();

        TreeMap<Integer, Pair> topViewMap = new TreeMap<>();
        System.out.println("Print Top View Using map: ");
        view.topViewUsingMap(br.getRoot(), 0,0, topViewMap);
        for (HashMap.Entry<Integer, Pair> entry : topViewMap.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }

        System.out.println();

        TreeMap<Integer, Pair> bottomViewMap = new TreeMap<>();
        System.out.println("Print Bottom View Using map: ");
        view.bottomViewUsingMap(br.getRoot(), 0,0, bottomViewMap);
        for (HashMap.Entry<Integer, Pair> entry : bottomViewMap.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    int maxLeftLevel;
    public void leftView(Node node, int level) {
        if(node == null)
            return;
        if(level>=maxLeftLevel) {
            System.out.print(node.data + " ");
            maxLeftLevel++;
        }
        leftView(node.left, level+1);
        leftView(node.right, level+1);
    }

    int maxRightLevel;
    public void rightView(Node node, int level) {
        if(node == null)
            return;
        if(level>=maxRightLevel) {
            System.out.print(node.data + " ");
            maxRightLevel++;
        }
        rightView(node.right, level+1);
        rightView(node.left, level+1);
    }

    public void leftViewUsingMap(Node node, int level, Map<Integer, Integer> map) {
        if(node == null)
            return;
        map.putIfAbsent(level, node.data);
        leftViewUsingMap(node.left, level+1, map);
        leftViewUsingMap(node.right, level+1, map);
    }

    public void rightViewUsingMap(Node node, int level, Map<Integer, Integer> map) {
        if(node == null)
            return;
        map.putIfAbsent(level, node.data);
        leftViewUsingMap(node.right, level+1, map);
        leftViewUsingMap(node.left, level+1, map);
    }

    //Map[distance, Pair(level, data)]
    public void topViewUsingMap(Node node, int distance, int level, TreeMap<Integer, Pair> map) {
        if(node == null)
            return;
        if((map.get(distance) == null) || (level < map.get(distance).level))
            map.put(distance, new Pair(level, node.data));
        topViewUsingMap(node.left, distance-1, level+1, map);
        topViewUsingMap(node.right, distance+1, level+1, map);
    }
    //Map[distance, Pair(level, data)]
    public void bottomViewUsingMap(Node node, int distance, int level, TreeMap<Integer, Pair> map) {
        if(node == null)
            return;
        if((map.get(distance) == null) || (level >= map.get(distance).level))
            map.put(distance, new Pair(level, node.data));
        bottomViewUsingMap(node.left, distance-1, level+1, map);
        bottomViewUsingMap(node.right, distance+1, level+1, map);
    }
}
