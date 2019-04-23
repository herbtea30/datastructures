package com.herbtea.study.datastructure.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);
        LinkedList.ListIterator it = numbers.listIterator();
        it.add(5);
        it.next();
        it.add(15);
        System.out.println(numbers.toString());
        while (it.hasNext()){
            if((int) it.next() == 20){
                it.remove();
            }
        }
        System.out.println(numbers.toString());

    }
}
