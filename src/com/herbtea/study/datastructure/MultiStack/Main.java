package com.herbtea.study.datastructure.MultiStack;

import java.util.EmptyStackException;

public class Main {

    public static void main(String[] args) {
        FixedMultiStack fs = new FixedMultiStack(5);
        try {
            fs.push(0, 1);
            fs.push(0, 2);
            fs.push(0, 3);
            fs.push(0, 4);
            fs.push(0, 5);
            fs.push(0, 6);

            fs.push(1, 11);
            fs.push(1, 12);
            fs.push(1, 13);
            fs.push(1, 14);
            fs.push(1, 15);

            fs.push(2, 21);
            fs.push(2, 22);
            fs.push(2, 23);
            fs.push(2, 24);
            fs.push(2, 25);
        } catch (FullStackException e) {
            System.out.println("It's full");
        }
        try{
            System.out.println("Stack#0: "+ fs.pop(0));
            System.out.println("Stack#0: "+ fs.pop(0));
            System.out.println("Stack#0: "+ fs.peek(0));
            System.out.println("Stack#0: "+ fs.pop(0));
            System.out.println("Stack#0: "+ fs.isEmpty(0));
            System.out.println("Stack#0: "+ fs.pop(0));
            System.out.println("Stack#0: "+ fs.pop(0));
            System.out.println("Stack#0: "+ fs.isEmpty(0));

            System.out.println("Stack#1: "+ fs.pop(1));
            System.out.println("Stack#1: "+ fs.pop(1));
            System.out.println("Stack#1: "+ fs.peek(1));
            System.out.println("Stack#1: "+ fs.pop(1));
            System.out.println("Stack#1: "+ fs.isEmpty(1));
            System.out.println("Stack#1: "+ fs.pop(1));
            System.out.println("Stack#1: "+ fs.pop(1));
            System.out.println("Stack#1: "+ fs.isEmpty(1));
            
            System.out.println("Stack#2: "+ fs.pop(2));
            System.out.println("Stack#2: "+ fs.pop(2));
            System.out.println("Stack#2: "+ fs.peek(2));
            System.out.println("Stack#2: "+ fs.pop(2));
            System.out.println("Stack#2: "+ fs.isEmpty(2));
            System.out.println("Stack#2: "+ fs.pop(2));
            System.out.println("Stack#2: "+ fs.pop(2));
            System.out.println("Stack#2: "+ fs.isEmpty(2));
        }catch (EmptyStackException e){
            System.out.println("It's Empty");
        }

    }
}
