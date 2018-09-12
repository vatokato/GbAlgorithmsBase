package lesson5;

public class Exponent {
    public static int pow(int base, int p) {
        if(p==0) return 1;
        return pow(base, p-1) * base;
    }
    public static void main(String[] args) {
        System.out.println( pow(5,2));
    }
}
