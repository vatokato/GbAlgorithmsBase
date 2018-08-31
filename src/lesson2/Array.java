package lesson2;

import java.util.Arrays;

public class Array {
    private int[] arr;
    private int size;
    private boolean isSorted;

    private Array() {
        isSorted = false;
    }

    public Array(int size) {
        this();
        this.size = 0;
        arr = new int[size];
    }

    public Array(int... args) { // int[] args = new int[args.length];
        this();
        size = args.length;
        arr = args;
    }

    public boolean isSorted() {
        return isSorted;
    }

    public int length() {
        return size;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("WTF!");
        return arr[index];
    }

    public void set(int index, int value) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("WTF!");
        arr[index] = value;
    }

    public void append(int value) {
        if (size >= arr.length - 1) {
            int[] temp = arr;
            arr = new int[size * 2];
            System.arraycopy(temp, 0, arr, 0, size);
        }
        arr[size++] = value;
    }

    public boolean remove() {
        if (size == 0)
            return false;
        size--;
        return true;
    }

    // homework
    //сложность O(n)
    public int delete(int index) {
        int count = 0;
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("WTF!");

        for(int i=index;i<=size-1;i++) {
            arr[i]=arr[i+1];
            count++;
        }
        size--;
        System.out.println("delete iterations "+count);
        return count;
    }

    //сложность O(n), т.к. внутренними циклами из-за их потенциальной немногочисленности можно пренебречь
    public boolean deleteAll(int value) {
        int count = 0;
        for (int i=0; i<size; i++) {
            count++;
            if(arr[i]==value) {
                count+=this.delete(i--);
            }
        }
        System.out.println("deleteAll(value) iterations "+count);
        return true;
    }

    //сложность O(n)
    public boolean deleteAll() {
        size=0;
        arr = new int[size];
        return true;
    }

    public boolean isInArray(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }
// k << n == k * 2 ^ n
// k >> n == k / 2 ^ n
    public int find(int value) {
        if (!isSorted)
            throw new RuntimeException("Trying to search in unsorted array");
        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            m = (l + r) >> 1; // 8 = 00001000 >> 2 = 00000010 = 2
            if (value == arr[m]) {
                return m;
            } else {
                if (value < arr[m]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortBubble2() {
        int count=0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                count++;
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);

            }
        }
        isSorted = true;
        System.out.println("sortBubble2 iterations "+count+" O(n^2 /2)");
    }

    public void sortBubble() {
        int count=0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                count++;
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);

            }
        }
        isSorted = true;
        System.out.println("sortBubble iterations "+count+" O(n^2)");
    }


    public void sortSelect() {
        int count=0;
        int f;
        for (int i = 0; i < size; i++) {
            f = i;
            for (int j = i + 1; j < size; j++) {
                count++;
                if (arr[j] < arr[f])
                    f = j;
            }
            swap(i, f);
        }
        isSorted = true;
        System.out.println("sortSelect iterations "+count+" O(n^2 /2)");
    }

    public void sortInsert() {
        int count = 0;
        for (int i = 1; i < size; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                count++;
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        isSorted = true;
        System.out.println("sortInsert iterations " + count + " O( n^2 /4)");
    }


    public void sortCounting() {
        int count = 0;

        int maxValue = 0;
        for(int i=0;i<size;i++) {
            count++;
            if(maxValue<arr[i])
                maxValue=arr[i];
        }
        int[] tmp = new int[maxValue+1];

        for(int i=0; i<size; i++) {
            count++;
            tmp[ arr[i] ]++;
        }

        int index=0;
        for(int i=0; i<tmp.length; i++) {
            for(int j=0; j<tmp[i]; j++) {
                count++;
                arr[index++]=i;
            }

        }
        //System.out.println(Arrays.toString(tmp));
        System.out.println("sortInsert iterations " + count + " O(3n)");
    }

    @Override
    public String toString() {
        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}
