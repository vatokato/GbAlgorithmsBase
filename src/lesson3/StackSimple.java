package lesson3;

class StackSimple {
    private int maxSize;
    private char[] stackArr;
    private int top;

    public StackSimple(int size){
        this.maxSize = size;
        this.stackArr = new char[size];
        this.top = -1;
    }

    public void push(char i){
        stackArr[++top] = i;
    }
    public char pop(){
        return stackArr[top--];
    }
    public boolean isEmpty(){
        return (top == -1);
    }

    public int getSize() {
        return maxSize;
    }

    public String toString() {
        String result = "";
        for(int i=0; i<maxSize; i++) {
            result+=stackArr[i]+", ";
        }
        return result;

    }
}
