package com.herbtea.study.datastructure.LinkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public class ListIterator{
        private Node next;
        private Node lastReturned;
        private int nextIndex = 0;

        ListIterator(){
            next = head;
        }

        public Object next(){
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }



        public void remove() {
            if(nextIndex == 0){
                throw new IllegalStateException();
            }

            LinkedList.this.remove(nextIndex-1);
            nextIndex--;
        }

        public boolean hasNext() {
            return nextIndex < size();
        }

        public void add(Object input) {
            Node newNode = new Node(input);

            if(lastReturned == null) {
                head = newNode;
                newNode.next = next;
            } else if(lastReturned == tail) {
                tail = newNode;
            } else {
                lastReturned.next = newNode;
                newNode.next = next;
            }

            lastReturned = newNode;
            nextIndex++;
            size++;
       }
    }

    public ListIterator listIterator() {
        return new ListIterator();
    }

    //Node Inner class
    public static class Node {
        private Object data;
        private Node next;

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(Object input){
            this.data = input;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +"data=" + data +'}';
        }
    }

    public  void addFirst(Object input){
        Node newNode= new Node(input);
        newNode.next = head;
        head = newNode;
        size++;
        if(head.next == null) tail = head;
    }

    public void addLast(Object input) {
        Node newNode = new Node(input);
        if (size == 0) {
            addFirst(input);
        }else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public Node node(int index){
        Node x = head;
        for(int i=0;i<index;i++) {
            x = x.next;
        }
        return x;
    }

    public void add(int index, Object input){
        Node x = head;
        Node newNode = new Node(input);
        if(index == 0) {
            addFirst(input);
        } else {
            Node temp1 = node(index-1);
            Node temp2 = node(index);
            newNode.next = temp1.next;
            temp1.next = newNode;
            size++;
            if(newNode.next == null){
                tail = newNode;
            }
        }
    }

    public String toString() {
        if(head == null){
            return "[]";
        }
        Node temp = head;
        String str = "[";
        while(temp.next != null){
            str += temp.data + ", ";
            temp = temp.next;
        }
        str += temp.data;
        return str + "]";
    }

    public Object removeFirst() {
        Node temp  = head;
        head = head.next;
        Object returnData = temp.data;
        temp = null;
        size --;
        return returnData;
    }

    public Object remove(int index) {
        if(index==0){
            return removeFirst();
        }
        Node temp = node(index-1);
        Node todoDeleted = temp.next;
        temp.next = temp.next.next;
        Object returnData = todoDeleted.data;
        if(index == size-1){
            tail = temp;
        }
        todoDeleted = null;
        size--;
        return returnData;
       }
       public Object removeLast(){
        return remove(size-1);
       }

       public  int size(){
        return size;
       }

       public Object get(int index){
        Node temp = node(index);
        return temp.data;
       }

       public int indexOf(Object input){
            Node temp = head;
            for(int i=0;i<size;i++){
                if(temp.data == input ){
                    return i;
                }
                temp = temp.next;
            }
            return -1;
       }

}
