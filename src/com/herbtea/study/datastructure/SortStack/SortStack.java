package com.herbtea.study.datastructure.SortStack;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(6);
        s.push(3);
        s.push(1);
        s.push(2);
        sort(s);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }

    public static void sort(Stack<Integer> s1){
        Stack<Integer> s2 = new Stack<Integer>();
        while(!s1.isEmpty()){
            int tmp = s1.pop();
            while (!s2.isEmpty() && tmp < s2.peek()){
                    s1.push(s2.pop());
            }
            s2.push(tmp);
        }
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

}
