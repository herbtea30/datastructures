package com.herbtea.study.datastructure.MultiStack;

import java.util.EmptyStackException;

public class MultiStacks {

    private class StackInfo{
            public int start, dataSize, stackSize;
            public StackInfo(int start, int stackSize) {
                this.start = start;
                this.stackSize = stackSize;
                this.dataSize = 0;
            }
            public boolean isWithinStack(int index){
                if(index < 0 || index >= values.length){
                    return false;
                }
                //index가 시작인덱스보다 작으면, 배열 갯수만큼 더해줘야한다.
                //((-1%max) + max)%max
                int virtualIndex = index < start ? index + values.length : index;
                int end = start + stackSize;
                return start <= virtualIndex && virtualIndex < end;
            }
            public int getLastStackIndex(){
                return adjustIndex(start+stackSize - 1);
            }
            public int getLastDataIndex(){
               return adjustIndex(start+dataSize -1);
            }
            public int getNewDataIndex() {
                return adjustIndex(getLastDataIndex() + 1);
            }
            public boolean isFull() {
                return dataSize == stackSize;
            }
            public boolean isEmpty() {
                return dataSize == 0;
            }
    }

    private StackInfo[] info;
    private int[] values;

    public MultiStacks(int numOfStacks, int defaultSize) {
        info = new StackInfo[numOfStacks];
        for(int i=0;i<numOfStacks;i++){
            info[i] = new StackInfo(defaultSize * i, defaultSize);
        }
        values = new int[numOfStacks * defaultSize];
    }

    private void expand(int stackNum) {
        int nextStack = (stackNum + 1) % info.length;
        shift(nextStack);
        info[stackNum].stackSize++;
    }
    private void shift(int stackNum){
        StackInfo stack = info[stackNum];
        if(stack.dataSize >= stack.stackSize) {
            int nextStack = (stackNum +1) % info.length;
            shift(nextStack);
            stack.stackSize++;
        }
        int index = stack.getLastStackIndex();
        while(stack.isWithinStack(index)){
            values[index] = values[previousIndex(index)];
            index = previousIndex(index);
        }
        values[stack.start] = 0;
        stack.start = nextIndex(stack.start);
        stack.stackSize--;
    }
    public int numberOfElements() {
        int totalDataSize = 0;
        for(StackInfo sd : info) {
            totalDataSize += sd.dataSize;
        }
        return totalDataSize;
    }
    public boolean allStackAreFull(){
        return numberOfElements() == values.length;
    }
    //배열 크기를 벗어나는 가상인덱스를 다시 계산해서 실제 인덱스를 알려주는 함수
    private int adjustIndex(int index){
        int max = values.length;
        return ((index%max)+max) % max;
    }
    private int nextIndex(int index){
        return adjustIndex(index+1);
    }
    private  int previousIndex(int index){
        return adjustIndex(index-1);
    }
    //stack Functions
    public void push(int stackNum, int value) throws FullStackException {
        if(allStackAreFull()) {
            throw new FullStackException();
        }
        StackInfo stack = info[stackNum];
        if(stack.isFull()) {
            expand(stackNum);
        }
        values[stack.getNewDataIndex()] = value;
        stack.dataSize++;
    }
    public int pop(int stackNum) throws Exception {
        StackInfo stack = info[stackNum];
        if(stack.isEmpty()) {
            throw new EmptyStackException();
        }
        int last = stack.getLastDataIndex();
        int value = values[last];
        values[last] = 0;
        stack.dataSize--;
        return value;
    }
    public int peek(int stackNum) throws Exception {
        StackInfo stack = info[stackNum];
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        return values[stack.getLastDataIndex()];
    }
}
