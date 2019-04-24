package com.herbtea.study.datastructure.StackPopAt;

import com.herbtea.study.datastructure.MultiStack.FullStackException;

public class Stack<E> {
    class Node{
        E data;
        Node below;
        Node above;
        public Node(E data) {
            this.data = data;
        }
        int capacity;
        int size;
        Node top;
        Node bottom;
        public Node(int capacity) {
            this.capacity = capacity;
        }
        public boolean isEmpth() {
            return size == 0;
        }
        public boolean isFull(){
            return capacity == size;
        }
        public int size() {
            return size;
        }
        public void push(E d) throws FullStackException {
            if(isFull()){
                throw new FullStackException();
            }
            Node n = new Node(d);
        }

    }
}
