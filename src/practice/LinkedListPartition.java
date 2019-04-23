package practice;

import com.herbtea.study.datastructure.LinkedList.LinkedList;

public class LinkedListPartition {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(3);
        list.addLast(5);
        list.addLast(8);
        list.addLast(5);
        list.addLast(10);
        list.addLast(2);
        list.addLast(1);
        System.out.println(list.toString());

        LinkedList.Node result =  partition(list.node(0), 5);
        System.out.println(result.getData()
                + "//" + result.getNext().getData()
                + "//" + result.getNext().getNext().getData()
                + "//" + result.getNext().getNext().getNext().getData()
                + "//" + result.getNext().getNext().getNext().getNext().getData()
                + "//" + result.getNext().getNext().getNext().getNext().getNext().getData()
                + "//" + result.getNext().getNext().getNext().getNext().getNext().getNext().getData());

    }

    public static LinkedList.Node partition(LinkedList.Node node, int k){
        LinkedList.Node head = node;
        LinkedList.Node tail = node;

        while(node != null){
            LinkedList.Node next = node.getNext();
            if((int)node.getData() < k){
                node.setNext(head);
                head = node;
            } else {
                tail.setNext(node);
                tail = node;
            }
            node = next;
        }
        tail.setNext(null);
        return head;
    }
}
