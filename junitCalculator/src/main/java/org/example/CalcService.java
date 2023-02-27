package org.example;

import java.util.InputMismatchException;

/**
 * Project: junitCalculator
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 30.01.2023 21:59 |
 * Created with IntelliJ IDEA
 */
public class CalcService {
    //TODO: сделать возврат? сделать параметры?

    public int calc(int firstNum, String symbol, int secondNum) throws ArithmeticException, InputMismatchException {
        try {
            if ((firstNum == Integer.MAX_VALUE || secondNum == Integer.MAX_VALUE)
                    && symbol.charAt(0) == '+' || symbol.charAt(0) == '*')
                throw new InputMismatchException();
            switch (symbol.charAt(0)) {
                case '+' : return(firstNum + secondNum);
                case '-' : return(firstNum - secondNum);
                case '*' : return(firstNum * secondNum);
                case '/' : return(firstNum / secondNum);
                case '^' : return((int)Math.pow(firstNum, secondNum));
                default : throw new ArithmeticException("Символ " + symbol + " не поддерживается!" +
                        " Валидные символы: +, -, *, /, ^");
            }
        } catch (ArithmeticException e) {
            throw new ArithmeticException();
        }
    }
}
