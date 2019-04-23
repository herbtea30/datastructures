package com.herbtea.study.datastructure.LinkedList;

public class Palindrome1 {
    boolean isPalindrome(LinkedList.Node head){
        LinkedList.Node reversed = reverseAndClone(head);
        return isEquals(head, reversed);
    }

    LinkedList.Node reverseAndClone(LinkedList.Node node){
        LinkedList.Node head = null;
        while (node != null){
            LinkedList.Node n = new LinkedList.Node(node.getData());
            n.setNext(head); //앞으로 연결작업
            head = n;
            node = node.getNext();
        }
        return head;
    }

    private boolean isEquals(LinkedList.Node head, LinkedList.Node reversed) {
        while (head != null && reversed != null){
            if(head.getData() != reversed.getData()){
                return false;
            }
            head = head.getNext();
            reversed = reversed.getNext();
        }
        return head == null && reversed == null;
    }
}
