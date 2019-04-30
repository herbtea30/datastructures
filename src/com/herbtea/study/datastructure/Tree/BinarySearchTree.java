package com.herbtea.study.datastructure.Tree;

class Tree{
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    Node root;
    public  void makeTree(int[] a){
        root = makeTree(a, 0, a.length-1);
    }

    private Node makeTree(int[] a, int start, int end) {
        if(start > end) return null; //재귀호출 종료지점 지정(중요)
        int mid = (start+end) / 2;
        Node node = new Node(a[mid]);
        node.left = makeTree(a, start, mid -1);
        node.right = makeTree(a, mid+1, end);
        return node;
    }
    public void searchBTree(Node n, int find) {
        if(find < n.data){
            System.out.println("Data is smaller than " + n.data);
            searchBTree(n.left, find);
        } else if(find > n.data){
            System.out.println("Data is biggest than " + n.data);
            searchBTree(n.right, find);
        } else {
            System.out.println("Data found!" + n.data);
        }
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        int [] a= new int[10];
        for(int i=0;i<a.length;i++){
            a[i] = i;
        }
        Tree tree = new Tree();
        tree.makeTree(a);
        tree.searchBTree(tree.root, 2);
    }
}
