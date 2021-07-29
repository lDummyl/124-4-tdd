package users.homework.codetotest.calculator;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        Context calc = new Context();
        System.out.println("Введите число");
        while (true) {
            char key = (char) System.in.read();
            if(key >= ' ') {
                calc.press(key);
            } else {
                System.out.println("Введите символ (числа 0-9, + - * / =, для сброса введите c)");
            }
        }

    }
}
