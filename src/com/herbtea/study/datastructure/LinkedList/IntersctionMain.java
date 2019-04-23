package com.herbtea.study.datastructure.LinkedList;

public class IntersctionMain {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(6);
        list1.addLast(7);
        list1.addLast(8);

        list2.addLast(7);
        list2.addLast(8);
        list2.addLast(9);
        list2.add(3, list1.node(5));
        list2.add(4, list1.node(6));
        list2.add(5, list1.node(7));
        System.out.println(list1.node(5) == list2.node(3));

        System.out.println(list1.toString());
        System.out.println(list2.toString());

    }
}
