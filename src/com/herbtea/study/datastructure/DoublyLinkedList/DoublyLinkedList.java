package com.herbtea.study.datastructure.DoublyLinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public ListIterator listIterator() {
        return new ListIterator();
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

        public boolean hasPrevious(){
            return nextIndex > 0;
        }

        public Object previous(){
            if(next == null) {
                lastReturned = next = tail;
            } else {
                lastReturned = next = next.prev;
            }
            nextIndex--;
            return lastReturned.data;
        }

        public void remove() {
            if(nextIndex == 0){
                throw new IllegalStateException();
            }
            Node n = lastReturned.next;
            Node p = lastReturned.prev;
            //처음 중간 끝 세가지 케이스가 존재함.
            if(p == null) {
                head = n;
                head.prev = null;
                lastReturned = null;
            } else {
                p.next = next;
                lastReturned.prev = null;
            }
            if(n == null){
                tail = p;
                tail.next = null;
                lastReturned = p;
            } else {
                n.prev = p;
            }
            if(next == null) {
                lastReturned = tail;
            }else {
                lastReturned = next.prev;
            }

            size --;
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
                next.prev = newNode;
            }  else {
                lastReturned.next = newNode;
                newNode.prev = lastReturned;
                if(next != null) {
                    newNode.next = next;
                    next.prev = newNode;
                } else {
                    tail = newNode;
                }
            }
            lastReturned = newNode;
            nextIndex++;
            size++;
       }
    }


    //Node Inner class
    private class Node {
        private Object data;
        private Node next;
        private Node prev;

        public Node(Object input){
            this.data = input;
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {
            return "Node{" +"data=" + data +'}';
        }
    }

    public  void addFirst(Object input){
        Node newNode= new Node(input);
        newNode.next = head;
        if(head != null)  head.prev = newNode;
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
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    Node node(int index){
        Node x = null;
        //전체 사이즈의 절반보다 인덱스가 작으면 앞에서 부터 탐색
        if(size/2 > index) {
            x=head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        //전체 사이즈의 절반보다 인덱스가 크면 뒤에서 부터 탐색
        } else {
            x=tail;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
        }
        return x;
    }

    public void add(int index, Object input){
        if(index == 0) {
            addFirst(input);
        } else {
            Node temp1 = node(index-1);
            Node temp2 = node(index);
            Node newNode = new Node(input);
            temp1.next = newNode;
            newNode.next = temp2;
            if(temp2 != null) {
                temp2.prev = newNode;
            }
            newNode.prev = temp1;
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
        if(head != null) head.prev = null;
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
        if(temp.next != null) temp.next.prev = temp;
        if(todoDeleted == tail) {
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
