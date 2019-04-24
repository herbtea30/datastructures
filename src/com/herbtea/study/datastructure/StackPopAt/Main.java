package com.herbtea.study.datastructure.StackPopAt;

public class Main {
    public static void main(String[] args) {
        SetOfStacks sos = new SetOfStacks(3);
        sos.push(1);
        sos.push(2);
        sos.push(3);

        sos.push(4);
        sos.push(5);
        sos.push(6);

        sos.push(7);
        sos.push(8);

        System.out.println(sos.popAt(0));
        System.out.println(sos.popAt(1));


    }
}
