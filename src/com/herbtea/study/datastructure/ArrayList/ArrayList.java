package com.herbtea.study.datastructure.ArrayList;

public class ArrayList {
    private int size = 0;
    private Object[] elementData = new Object[100];

    public class ListIterator{
        private int nextIndex = 0;
        public Object next() {
            return elementData[nextIndex++];
        }

        public boolean hasNext() {
            return nextIndex < size();
        }

        public Object previous() {
            return elementData[--nextIndex];
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public void add(Object element) {
            ArrayList.this.add(nextIndex++, element);
        }

        public void remove() {
            ArrayList.this.remove(--nextIndex);
        }
    }

    public boolean addFirst(Object input) {
        return add(0, input);
    }
    public boolean add(int index, Object input) {
        for(int i=size-1;i>= index;i--){
            elementData[i+1] = elementData[i];
        }
        elementData[index] = input;
        size++;
        return true;
    }
    public boolean addLast(Object input) {
        elementData[size] = input;
        size++;
        return true;
    }

    public String toString(){
        String result = "[";
        for( int i=0;i<size;i++){
            result += elementData[i];
            if(i <size-1) result += ", ";
        }

        return result+ "]";
    }

    public Object remove(int index) {
        Object removed = elementData[index];
        for(int i= index+1;i <= size-1;i++){
            elementData[i-1] = elementData[i];
        }
        size--;
        elementData[size] = null;
        return removed;
    }

    public Object removeFirst(){
        return remove(0);
    }

    public Object removeLast(){
        return remove(size-1);
    }

    public Object get(int index) {
        return elementData[index];
    }

    public int size() {
        return size;
    }

    public int indexOf(Object input) {
        for(int i=0;i<size;i++){
            if(elementData[i] == input) return i;
        }
        return -1;
    }

    public ListIterator listIterator() {
        return new ListIterator();
    }

}
