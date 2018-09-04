package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Homework {
    public static void main(String[] args) throws IOException {
        String input;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);


//        //1
//        while (true) {
//            System.out.print("Введите слово: ");
//            input = br.readLine();
//            if (input.equals("exit")) break;
//            Bracket.check(input);
//        }

//        //2
//        while (true) {
//            System.out.print("Введите слово: ");
//            input = br.readLine();
//            if (input.equals("exit")) break;
//            ReverseReading.reading(input);
//        }

//        //3
//        Deque d = new Deque(3);
//        d.insertLeft(1);
//        d.insertLeft(2);
//        d.insertLeft(3);
//        d.insertLeft(4);

//      //4
        PriorQueue p = new PriorQueue(5);
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(6);
        p.push(2);
        p.push(7);

    }
}
