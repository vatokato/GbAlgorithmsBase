package lesson1;

public class Main {
    public static void main(String[] args) {
        ex1();
        System.out.println("------------------");
        ex2();
        System.out.println("------------------");
        ex3();
        System.out.println("Правила подсчета: Считал циклы, на операции не смотрел)");
    }


    public static void ex1() {
        System.out.println(Math.pow(-5,3));
        System.out.println("в степень: " + pow(-5, 3));
        System.out.println("Сложность O(n)");
    }
    public static double pow (int a, int amount ) {
        double result = a;

        if(amount == 0) {
            return 1;
        }
        else if(amount<0) {
            for(int i = -1; i>amount; i-- ) {
                result*=a;
            }
            result = 1/result;
        }
        else if(amount>0) {
            for(int i = 1; i<amount; i++ ) {
                result*=a;
            }
        }
        return result;
    }

    // поиск мин в массиве
    public static void ex2() {
        int[] arr = {4,5,6,2,6,8,3,5,9};
        int min = arr[0];
        for(int i = 0; i<arr.length; i++) {
            if(min>arr[i])
                min = arr[i];
        }
        System.out.println("min = "+ min);
        System.out.println("Сложность O(n)");
    }

    // среднее арифметическое
    public static void ex3() {
        int[] arr = {4,5,6,2,6,8,3,5,9};
        int summ = 0;
        for(int i = 0; i<arr.length; i++) {
            summ+=arr[i];
        }
        double average = (double)summ/arr.length;

        System.out.println("Cумма = "+ summ);
        System.out.println("Кол-во элементов = "+ arr.length);
        System.out.println("Среднее арифметическое = "+ average);
        System.out.println("Сложность O(n)");
    }

}

