package com.herbtea.study.datastructure.Stack;

import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin> {
    public int min(){
        if(this.isEmpty()){
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }

    public void push(int value){
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    public static class Test{
        public static void main(String[] args) {
            StackWithMin stack = new StackWithMin();
            stack.push(3);
            stack.push(5);
            stack.push(1);
            stack.push(2);
            System.out.println("min : " + stack.min());
            System.out.println(stack.pop().value);
            System.out.println(stack.pop().value);
            System.out.println("min : " + stack.min());
        }
    }
}
