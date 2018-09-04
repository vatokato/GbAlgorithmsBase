package lesson3;

import lesson3.Bracket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


        String input;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        while (true) {
            input = br.readLine();
            if (input.equals("exit")) break;
            Bracket.check(input);
        }
    }
}
