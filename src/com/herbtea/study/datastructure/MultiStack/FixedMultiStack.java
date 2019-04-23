package com.herbtea.study.datastructure.MultiStack;

import com.sun.org.apache.xpath.internal.functions.FuncUnparsedEntityURI;

import java.util.EmptyStackException;

public class FixedMultiStack {
    private int numOfStacks = 3;
    private int stackCapacity;
    private  int[] sizes;
    private  int[] values;


    public FixedMultiStack(int stackSize){
        this.stackCapacity = stackSize;
        values = new int[numOfStacks * stackSize];
        sizes = new int[numOfStacks];
    }

    public void push(int stackNum, int value) throws FullStackException {
        if(isFull(stackNum)) {
            throw new FullStackException();
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum){
        if(isEmpty(stackNum)){
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum){
        if(isEmpty(stackNum)){
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
    }
    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset+size-1;
    }
    private boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

}
