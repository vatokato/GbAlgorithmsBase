package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Homework {
    public static void main(String[] args) throws IOException {
        String input;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);


// 1
//        while (true) {
//            System.out.print("Введите слово: ");
//            input = br.readLine();
//            if (input.equals("exit")) break;
//            Bracket.check(input);
//        }

// 2
//        while (true) {
//            System.out.print("Введите слово: ");
//            input = br.readLine();
//            if (input.equals("exit")) break;
//            ReverseReading.reading(input);
//        }

// дек еще делается
        Deque d = new Deque(2);
        d.insertRight(1);
        d.insertRight(2);
        d.insertRight(3);
        d.insertRight(4);
        d.insertRight(5);
        d.removeLeft();
        d.removeLeft();
    }

}
