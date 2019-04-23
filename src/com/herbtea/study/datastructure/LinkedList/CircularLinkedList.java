package com.herbtea.study.datastructure.LinkedList;

public class CircularLinkedList {
    LinkedList.Node findBeginning(LinkedList.Node head){
        LinkedList.Node fast = head;
        LinkedList.Node slow = head;

        //만나는 지점을 찾는다. 연결리스트 안에서 LOOP_SIZE-k만큼 들어간 상태이다.
        while(fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast) { //충돌
                break;
            }
        }

        //에러체크. 만나는 지점이 없다면 루프도 없다 */
        if(fast == null || fast.getNext() == null){
            return null;
        }

        //slow를 head로 옮기고, fast는 그대로 둔다. 이 둘은 루프시작지점에서 K만큼 떨어져있다.
        //이 둘이 같은 속도로 움직인다면 시작지점에서 만나게 된다.
        slow = head;
        while(slow != fast){
            slow = slow.getNext();
            fast = fast.getNext();
        }

        //둘다 루프의 시작 지점을 기리킨다.
        return fast;
    }
}
