package lesson5;

public class Hanoi {
    Pole s1, s2, s3;
    int turn;
    Pole[] poles;
    int from_pole;
    int tmp_pole;
    int to_pole;

    public Hanoi(int count) {
        turn = 0;
        poles = new Pole[]{new Pole(count),new Pole(count),new Pole(count)};
        from_pole = 0;
        tmp_pole = 1;
        to_pole = 2;


        poles[0].push(4);
        poles[0].push(3);
        poles[0].push(2);
        poles[0].push(1);

        turn(from_pole, 2);
    }

    public boolean turn(int from, int n) {
        turn++;
        if(poles[from].isEmpty()) return false;

        turn(from,n-1);
        print();
        return false;
    }

    public void print() {
        System.out.println("----"+turn+"----");
        for (int i = 0; i < poles.length; i++) {
            System.out.println(poles[i]);
        }
    }

    public static void main(String[] args) {
        Hanoi h = new Hanoi(4);
    }

    class Pole {
        private int[] stack;
        private int top;

        public Pole(int size) {
            stack = new int[size];
            top=-1;
        }

        public boolean push(int i){
            if(isFull()) {
                System.err.println("стек полон");
                return false;
            }
            if(!isEmpty() && i>stack[top]) {
                System.err.println("нельзя надеть "+i+" на "+ stack[top]);
                return false;
            }
            stack[++top] = i;
            return true;
        }
        public int pop(){
            if(isEmpty()) return 0;

            int tmp = stack[top];
            stack[top--]=0;
            return tmp;
        }
        public int peek(){
            return stack[top];
        }
        public boolean isEmpty(){
            return (top == -1);
        }
        public boolean isFull(){
            return (top == stack.length-1);
        }
        public int getSize() {
            return stack.length;
        }
        public String toString() {
            String result = "";
            for(int i=0; i<stack.length; i++) {
                result+=stack[i]+"-";
            }
            return result;

        }
    }
}
