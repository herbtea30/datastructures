package com.herbtea.study.datastructure.StackPopAt;

import com.herbtea.study.datastructure.MultiStack.FullStackException;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<E> {
    class Node {
        E data;
        Node below;
        Node above;
        public Node(E data) {
            this.data = data;
        }
    }
    int capacity;
    int size;
    Node top;
    Node bottom;
    public Stack(int capacity) {
            this.capacity = capacity;
        }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull(){
            return capacity == size;
        }
    public int size() {
            return size;
        }

    public void push(E d) throws FullStackException {
        if(isFull()) throw new FullStackException();
        Node n = new Node(d);
        push(n);
    }
    public void push(Node n) throws FullStackException{
        if(isFull()) throw new FullStackException();
        if(isEmpty()){
            top = n;
            bottom = n;
        } else {
            top.above = n;
            n.below = top;
            top = n;
        }
        size++;
    }
    public E pop() {
        if(isEmpty()) throw new EmptyStackException();
        E data = top.data;
        top = top.below;
        if(top == null){
            bottom = null;
        } else {
            top.above = null;
        }
        size--;
        return data;
    }
    public Node popBottom() {
        if(isEmpty()) throw new EmptyStackException();
        Node n = bottom;
        bottom = bottom.above;
        if(bottom==null){
            top = null;
        } else {
            bottom.below = null;
        }
        size--;
        return n;
    }
}
class SetOfStacks {
    int capacity;
    ArrayList<Stack <Integer>> stacks = new ArrayList<Stack<Integer>>();
    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }
    public void addStack(){
        stacks.add(new Stack<Integer>(capacity));
    }
    public void removeLastStack(){
        stacks.remove(stacks.size()-1);
    }
     public Stack<Integer> getLastStack() {
        if(stacks.size() == 0) return null;
        return stacks.get(stacks.size()-1);
     }
     public void push(int data){
        Stack<Integer> last = getLastStack();
        if(last == null || last.isFull()){
            addStack();
            last = getLastStack();
        }
         try {
             last.push(data);
         } catch (FullStackException e) {
             e.printStackTrace();
         }
     }
     public int pop() {
        Stack<Integer> last = getLastStack();
        if(last == null || last.isEmpty()) throw new EmptyStackException();
        int data = last.pop();
        if(last.isEmpty()) removeLastStack();
        return data;
     }
     public int popAt(int index){
        if(stacks.size() <= 0){
            throw new EmptyStackException();
        }
        if(index<0 || index >= stacks.size()){
            throw new IndexOutOfBoundsException();
        }
        Stack<Integer> stack = stacks.get(index);
        if(stack.isEmpty() || stack == null) {
            throw new EmptyStackException();
        }
        int data = stack.pop();
        shiftLeft(index);
        return data;
     }

    private void shiftLeft(int index) {
        if(index < stacks.size()-1){
            Stack<Integer> right = stacks.get(index+1);
            Stack<Integer> left = stacks.get(index);
            try {
                left.push(right.popBottom());
            } catch (FullStackException e) {
                e.printStackTrace();
            }
            if(!right.isEmpty() ) stacks.remove(index+1);
            shiftLeft(index+1);
        }
    }
}