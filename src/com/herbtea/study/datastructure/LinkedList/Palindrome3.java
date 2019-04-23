package com.herbtea.study.datastructure.LinkedList;

class Result{
    public LinkedList.Node node;
    public boolean result;

    public Result(LinkedList.Node node, boolean result) {
        this.node = node;
        this.result = result;
    }
}
public class Palindrome3 {
    boolean isPalindrome(LinkedList.Node head) {
        int length = lengthOfList(head);
        Result p = isPalindromeRecurse(head, length);
        return p.result;
    }

    private Result isPalindromeRecurse(LinkedList.Node head, int length) {
        if(head == null || length <= 0){
            return new Result(head, true);
        } else if(length == 1) {
            return new Result(head.getNext(), true);
        }
        //부분리스트를 재귀호출
        Result res = isPalindromeRecurse(head.getNext(), length-2);
        //아래호출결과 회문이 아니라면 그 결과값을 반환한다.
        if(!res.result || res.node == null) {
            return res;
        }
        //두 노드의 값이 같은지 확인
        res.result = (head.getData() == res.node.getData());
        //그 다음 비교할 노드 반환
        res.node = res.node.getNext();

        return res;
    }
    private int lengthOfList(LinkedList.Node head) {
        int size = 0;
        while(head != null){
            size++;
            head = head.getNext();
        }
        return size;
    }
}
