package com.herbtea.study.datastructure.LinkedList;

class Results {
    public LinkedList.Node tail;
    public int size;
    public Results(LinkedList.Node tail, int size) {
        this.tail = tail;
        this.size = size;
    }
}
public class Intersection {
    LinkedList.Node findIntersection(LinkedList.Node list1, LinkedList.Node list2){
        if(list1 == null || list2 == null) return null;

        //두 리스트의 마지막 노드와 사이즈를 구한다
        Results result1 = getTailAndSize(list1);
        Results result2 = getTailAndSize(list2);

        //마지막노드가 다르면 교집합이 없다고 판단
        if(result1.tail != result2.tail){
            return null;
        }

        //각 연결리스트의 시작점에 포인터를 세팅
        LinkedList.Node shorter = result1.size < result2.size ? list1: list2;
        LinkedList.Node longer = result1.size > result2.size ? list1 : list2;

        //길이가 긴 연결리스트의 포인터를 길이 차이만큼 앞으로 이동시킴
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        //두 포인터가 만날때까지 반복
        while(shorter != longer){
            shorter = shorter.getNext();
            longer = longer.getNext();
        }

        //둘중에 하나를 리턴
        return longer;

    }

    private LinkedList.Node getKthNode(LinkedList.Node head, int k) {
        LinkedList.Node current = head;
        while(k > 0 && current !=null){
            current = current.getNext();
            k--;
       }
        return current;
    }

    private Results getTailAndSize(LinkedList.Node list) {
        if(list == null) return null;

        int size = 1;
        LinkedList.Node current = list;
        while(current.getNext() != null) {
            size++;
            current = current.getNext();
        }
        return new Results(current, size);
    }


}