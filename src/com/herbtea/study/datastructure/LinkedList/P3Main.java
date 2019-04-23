package com.herbtea.study.datastructure.LinkedList;

public class P3Main {
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

        Palindrome3 p3 = new Palindrome3();
        boolean result = p3.isPalindrome(list.node(0));
        System.out.println(result);
    }
}
