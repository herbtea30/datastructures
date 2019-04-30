package com.herbtea.study.datastructure.Tree01;

import java.util.ArrayList;
import java.util.LinkedList;

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
    Tree(int size){
        root = makeBST(0, size -1);
    }
    Node makeBST(int start, int end){
        if(start > end) return null;
        int mid = (start+end)/2;
        Node node = new Node(mid);
        node.left = makeBST(start, mid-1);
        node.right = makeBST(mid+1, end);
        return node;
    }
    ArrayList<LinkedList<Node>> BSTtoList() {
        //결과값으로 넘겨줄 배열 안에 링크드리스트를 담아서 반환
        ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
        //이진트리 루트노드, 결과값을 반환할 링크드리스트, 트리의 레벨
        BSTtoList(root, lists, 0);
        return lists;
    }
    void BSTtoList(Node root, ArrayList<LinkedList<Node>> lists, int level) {
        if(root == null) return; //재귀호출 종료지점
        LinkedList<Node> list = null;
        if(lists.size() == level){
            list = new LinkedList<Node>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        BSTtoList(root.left, lists, level+1);
        BSTtoList(root.right, lists, level+1);
    }

    ArrayList<LinkedList<Node>> BSTtoList2() {
        ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
        LinkedList<Node> cureent = new LinkedList<Node>(); //현재레벨 노드 담을 링크드리스트생성
        if(root != null) {
            cureent.add(root);
        }
        while(cureent.size() > 0 ){
            result.add(cureent);
            LinkedList<Node> parents = cureent;
            cureent = new LinkedList<Node>();
            for(Node parent : parents){
                if(parent.left != null) cureent.add(parent.left);
                if(parent.right != null) cureent.add(parent.right);
            }
        }
        return result;
    }
    void printList(ArrayList<LinkedList<Node>> arr) {
        for(LinkedList<Node> list : arr){
            for(Node nodee: list){
                System.out.print(nodee.data + " ");
            }
            System.out.println();
        }
    }

}
public class BtreeInLinkedList {
    public static void main(String[] args) {
        Tree t = new Tree(10);
        t.printList(t.BSTtoList2());

    }
}
