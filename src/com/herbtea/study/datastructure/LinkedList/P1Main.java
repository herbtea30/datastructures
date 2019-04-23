package com.herbtea.study.datastructure.LinkedList;

public class P1Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        //0 1 2 3 2 1 0
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);
        list.addLast(0);

        Palindrome1 p1 = new Palindrome1();
        boolean result  = p1.isPalindrome(list.node(0));
        System.out.println(result);
    }
}
