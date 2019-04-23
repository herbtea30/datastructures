package com.herbtea.study.datastructure.LinkedList;

public class P2Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);
        list.addLast(0);
        System.out.println(list.toString());

        Palindrome2 p2 = new Palindrome2();
        boolean result = p2.isPalindrome(list.node(0));
        System.out.println(result);
    }
}
