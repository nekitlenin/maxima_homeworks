import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Project: homework12
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 30.01.2023 21:59 |
 * Created with IntelliJ IDEA
 */
public class Calc {

    public Calc() {
        try {
            System.out.println("Введите первое число:");
            Scanner scanner = new Scanner(System.in);
            int firstNum = scanner.nextInt();
            System.out.println("Введите арифметический символ:");
            String symbol = scanner.next();
            System.out.println("Введите второе число:");
            int secondNum = scanner.nextInt();
            calcEngine(firstNum, symbol, secondNum);
        } catch (InputMismatchException e) {
            System.err.println("Ошибка, введите корректное значение!");
            if (e.getMessage() == null)
                System.err.println("Принимаются только цифры!");
            else if (e.getMessage().split(" ")[0].equals("For"))
                System.err.println("Введите значение от " + Integer.MIN_VALUE + " до " + Integer.MAX_VALUE);
        } catch (ArithmeticException e) {
            System.err.println("Арифметическая ошибка! (" + e.getMessage() + ")");
        }
    }

    private void calcEngine(int firstNum, String symbol, int secondNum) {
        switch (symbol.charAt(0)) {
            case '+' -> System.out.println(firstNum + secondNum);
            case '-' -> System.out.println(firstNum - secondNum);
            case '*' -> System.out.println(firstNum * secondNum);
            case '/' -> System.out.println(firstNum / secondNum);
            case '^' -> System.out.println(Math.pow(firstNum, secondNum));
            default -> throw new InvalidSymbolException("Символ " + symbol + " не поддерживается!" +
                    " Валидные символы: +, -, *, /, ^");
        }
    }
}
