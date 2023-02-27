package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CalcService calcService = new CalcService();
        System.out.println("Введите первое число:");
        Scanner scanner = new Scanner(System.in);
        int firstNum = scanner.nextInt();
        System.out.println("Введите арифметический символ:");
        String symbol = scanner.next();
        System.out.println("Введите второе число:");
        int secondNum = scanner.nextInt();
        System.out.println(calcService.calc(firstNum, symbol, secondNum));
    }
}
