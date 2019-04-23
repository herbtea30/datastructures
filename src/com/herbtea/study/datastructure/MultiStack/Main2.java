package com.herbtea.study.datastructure.MultiStack;

import java.util.EmptyStackException;

public class Main2 {
    public static void main(String[] args) {
        MultiStacks ms = new MultiStacks(3, 5);
        
        try{
            ms.push(0, 1);
            ms.push(0, 2);
            ms.push(0, 3);
            ms.push(0, 4);
            ms.push(0, 5);
            ms.push(0, 6);
            ms.push(0, 7);
            ms.push(0, 8);
            ms.push(0, 9);

            ms.push(1, 11);
            ms.push(1, 12);
            ms.push(1, 13);
            ms.push(1, 14);
            ms.push(1, 15);

        } catch (FullStackException e) {
            System.out.println("It's full");
        }

        try{
            System.out.println("Stack#0: "+ ms.pop(0));
            System.out.println("Stack#0: "+ ms.pop(0));
            System.out.println("Stack#0: "+ ms.pop(0));
            System.out.println("Stack#0: "+ ms.pop(0));
            System.out.println("Stack#0: "+ ms.pop(0));
            System.out.println("Stack#0: "+ ms.pop(0));
            System.out.println("Stack#0: "+ ms.pop(0));
            System.out.println("Stack#0: "+ ms.pop(0));
            System.out.println("Stack#0: "+ ms.pop(0));

            System.out.println("Stack#1: "+ ms.pop(1));
            System.out.println("Stack#1: "+ ms.pop(1));
            System.out.println("Stack#1: "+ ms.pop(1));
            System.out.println("Stack#1: "+ ms.pop(1));
            System.out.println("Stack#1: "+ ms.pop(1));

        } catch (Exception e) {
            System.out.println("It's Empty");
        }
    }
}
