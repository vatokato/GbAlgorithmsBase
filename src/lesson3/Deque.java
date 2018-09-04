package lesson3;


import java.util.Arrays;

public class Deque {
    private int size;
    private int[] queue;
    private int head;
    private int tail;
    private int items;

    public Deque(int size) {
        this.size = size;
        queue = new int[size];
        head = 0;
        tail = -1;
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == size;
    }

    public int size() {
        return items;
    }

    public void insertRight(int i) {
        if (isFull()) {
            riseArr();
        }
        if (tail == size - 1)
            tail = -1;
        queue[++tail] = i;
        items++;
        System.out.println(peekLeft()+" "+Arrays.toString(queue)+" "+peekRight());
    }

    public void insertLeft(int i) {
        if (isFull()) {
            riseArr();
        }
        if (head == 0)
            head = size;
        queue[--head] = i;
        items++;
        if(items==1) tail=head; // при первом добавлении инициализируется хвост
        System.out.println(peekLeft()+" "+Arrays.toString(queue)+" "+peekRight());
    }

    public int removeLeft() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        queue[head] = 0;
        int temp = queue[head++];
        head %= size;
        items--;
        System.out.println(peekLeft()+" "+Arrays.toString(queue)+" "+peekRight());
        return temp;
    }


    public int removeRight() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        queue[tail] = 0;
        int temp = queue[tail--];
        if(tail==-1)  tail = size-1;
        items--;
        System.out.println(peekLeft()+" "+Arrays.toString(queue)+" "+peekRight());
        return temp;
    }

    public int peekLeft() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return queue[head];
    }
    public int peekRight() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return queue[tail];
    }

    private void riseArr() {
        size *= 2;
        int[] temp = new int[size];
        if (tail >= head) {
            System.arraycopy(queue, 0, temp, 0, queue.length);
        } else {
            System.arraycopy(queue, head,
                    temp, 0,
                    queue.length - head);
            System.arraycopy(queue, 0, temp, queue.length - head, head);
            head = 0;
            tail = queue.length-1;
        }
        queue = temp;
    }
}
