package com.herbtea.study.datastructure.LinkedList;

import com.herbtea.study.datastructure.Stack.Stack;

public class Palindrome2 {
    //fastRunner and slowRunner
    boolean isPalindrome(LinkedList.Node head){
        LinkedList.Node fast = head;
        LinkedList.Node slow = head;

        Stack stack = new Stack();

        //스택에 앞의 절반 원소를 담는다.
        while (fast != null && fast.getNext() != null) {
            stack.push(slow.getData());
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        //홀수일 경우 가운데 원소 넘기기
        if(fast != null){
            slow = slow.getNext();
        }

        while(slow != null){
            int top = (int)stack.pop();
            if(top != (int)slow.getData()){
                return false;
            }
            slow = slow.getNext();
        }
        return true;
    }
}
