package lesson3;

import java.util.Arrays;

class PriorQueue {
    private int maxSize;
    private int items;
    private int[] stackArr;
    private int top;

    public PriorQueue(int size){
        this.maxSize = size;
        this.items = 0;
        this.stackArr = new int[size];
        this.top = -1;
    }

    public void push(int p){
        if(isFull()) {
            System.out.println("Очередь переполнена");
            return;
        }
        int i;
        for(i=items-1; i>=0; i--) {
            if(p > stackArr[i]) {
                if(i>maxSize) continue;
                stackArr[i+1] = stackArr[i];
            }
            else break;
        }
        stackArr[i+1] = p;
        top++;
        items++;
        System.out.println(Arrays.toString(stackArr));
    }

    public int pop(){
        items--;
        System.out.println(Arrays.toString(stackArr));
        return stackArr[top--];

    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (maxSize == items);
    }

    public int getSize() {
        return maxSize;
    }

}
