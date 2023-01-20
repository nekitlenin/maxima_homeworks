import java.util.Scanner;

/**
 * Project: homework09
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 12.01.2023 00:14 |
 * Created with IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
//        menu();
        table();
        fibonacci(5, 1);
        fibonacci(5, 2);
        fibonacci(5, 3);
        sumOfNumber(1234, 1);
        sumOfNumber(1234, 2);
        palindromesCount("aba fas ahahahah 101 5050505");
        luckyTime();
        month(8, 1);
        month(8, 2);
        decimalToBinary(123);
        degree(5);
        recursionSumOfNumber(12345);
    }

    /**
     * 1.
     * Выведите в консоль таблицу умножения.
     * (Решение должно быть без массивов, только циклы)
     */
    static void table() {
        for (int i = 1; i < 10; i++)
            for (int j = 1; j < 11; j++)
                System.out.println(i + " * " + j + " = " + i * j);
    }

    /**
     * 2.
     * Выведите на экран все числа Фибоначчи в заданном интервале.
     * (От 1 до N, где N правый интервал. Задаётся пользователем)
     * Реализовать данную задачу через разные циклы(for, while, do wile)
     * 0 1 1 2 3 5 8 13 21 34 55 89 sum
     * a+b a+b a+b a+b ...
     * ..a+b a+b a+b a+b ...
     */
    static void fibonacci(int len, int cycleType) {
        int sum = 0;
        int a;
        int b = 1;
        if (cycleType == 1) {
            for (int i = len; i > 0; i--) {
                System.out.print(sum + " ");
                a = sum + b;
                sum = b;
                b = a;
            }
        } else if (cycleType == 2) {
            while (len > 0) {
                System.out.print(sum + " ");
                a = sum + b;
                sum = b;
                b = a;
                len--;
            }
        } else if (cycleType == 3) do {
            System.out.print(sum + " ");
            a = sum + b;
            sum = b;
            b = a;
            len--;
        } while (len > 0);
        else {
            System.err.println("Неверная команда");
            return;
        }
        System.out.println();
    }

    /**
     * 3.
     * Выведите в консоль сумму всех цифр, от заданного числа.
     * (Число заранее неизвестно)
     * Например у числа 1234, сумма цифр будет 1 + 2 + 3 + 4 = 10.
     * В консоль выведем просто 10
     * * Попробовать решить несколькими вариантами при помощи разных циклов
     */
    static void sumOfNumber(int num, int cycleType) {
        int sum = 0;

        if (cycleType == 1) {
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
        } else if (cycleType == 2) {
            for (; num != 0; ) {
                sum += num % 10;
                num /= 10;
            }
        } else {
            System.err.println("Неверная команда");
            return;
        }
        System.out.println("Сумма чисел - " + sum);
    }

    /**
     * 4.
     * Hа вход подаётся строка. В ней N слов.
     * Вывести в консоль кол-во слов - палиндромов
     */
    static void palindromesCount(String string) {
        int count = 0;
        String[] words = string.split(" ");
        char[] chars;
        for (int i = 0; i < words.length; i++) {
            chars = words[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                int last = 1;
                if (j == last)
                    count++;
                else if (chars[j] != chars[chars.length - last++])
                    break;
            }
        }
        System.out.println("Количество палиндромов в предложении - " + count);
    }

    /**
     * *5. На часах есть циферблат в формате от 00:00 до 24:00
     * Необходимо подсчитать когда и сколько раз в день происходит ситуация,
     * что цифры на циферблате часов симметричны.
     * Например при 01:10 в консоль выйдет сообщение:
     * Время 01:10 - Всего случаев: 1
     * Время 02:20 - Всего случаев: 2 и т.д.
     */
    static void luckyTime() {
        int count = 0;

        for (int i = 0; i < 24; i++) {
            String[] hours = getSeason(i);
            for (int j = 0; j < 60; j++) {
                String[] min = getSeason(j);
                if (hours[0].equals(min[1])) {
                    if (hours[1].equals(min[0]))
                        System.out.println(hours[0] + hours[1] + ":" + min[0] + min[1]
                                + " - " + ++count + "-й палиндром");
                }
            }
        }
    }

    private static String[] getSeason(int i) {
        String[] time = {"", ""};
        if (i < 10) {
            time[0] = "0";
            time[1] += i;
        } else {
            time[0] += i / 10;
            time[1] += i % 10;
        }
        return time;
    }

    /**
     * 6. (На логические операторы)
     * Напишите программу, которая по месяцу определяет какое сейчас время года.
     * Например если подать 2, то в консоль напишется Зима, 10 - Осень и т.д.
     * Выполнить задачу через if и switch
     */
    static void month(int month, int ifOrSwitch) {
        if (ifOrSwitch == 1) {
            if (month <= 0 || month >= 13)
                System.err.println("Такого месяца не бывает!");
            else if (month <= 2 || month == 12)
                System.out.println("Зима");
            else if (month <= 5)
                System.out.println("Весна");
            else if (month <= 8)
                System.out.println("Лето");
            else
                System.out.println("Осень");
        } else if (ifOrSwitch == 2) {
            switch (month) {
                case 12, 1, 2 -> System.out.println("Зима");
                case 3, 4, 5 -> System.out.println("Весна");
                case 6, 7, 8 -> System.out.println("Лето");
                case 9, 10, 11 -> System.out.println("Осень");
                default -> System.err.println("Такого месяца не бывает!");
            }
        } else
            System.out.println("Неверная команда");
    }

    /**
     * 7. (Рекурсия)
     * Решите при помощи рекурсии и цикла (2 разных решения)
     * задачу перевода из десятичной системы счисления в двоичную.
     */
    static void decimalToBinary(int decimalNum) {
        int output = decimalNum;
        int remainder;
        String result = "";
        while (decimalNum != 0) {
            remainder = decimalNum % 2;
            result = remainder + result;
            decimalNum = decimalNum / 2;
        }
        System.out.println("Число " + output + " в двоичном виде - " + result);

    }


    /**
     * 8. (Рекурсия)
     * Возведение числа 5 в N-ую степень.
     * На вход подаём степень, в ответе получаем число 5 в степени N.
     * Это решаем только через рекурсию, варианта через цикл не надо
     */
    static int degree(int d) {
        int num = 5;
        if (d == 1)
            return num;
        if (d > 0)
            num *= degree(--d);
        else if (d < 0)
            num *= degree(++d);
        return num;
    }

    /**
     * 9. (Рекурсия)
     * Решите задачу 3 через рекурсию,
     * при этом вывод в консоль должен прямо показывать этапы сложения.
     * Это значит в консоли мы должны увидеть следующее:
     * 1 + 2 + 3 + 4 = 10
     */
    static void recursionSumOfNumber(int num) {
        System.out.println(" = " + recursionSumOfNumberEngine(num));
    }

    private static int recursionSumOfNumberEngine(int num) {
        int sum = 0;

        if (num != 0) {
            sum = recursionSumOfNumberEngine(num / 10);
            sum += num % 10;
            if (num > 9)
                System.out.print(" + ");
            System.out.print(num % 10);
        }
        return sum;
    }

    static void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println('\n' + "Выберите задание:");
            System.out.println("1 - 1 задание");
            System.out.println("2 - 2 задание");
            System.out.println("3 - 3 задание");
            System.out.println("4 - 4 задание");
            System.out.println("5 - *5 задание");
            System.out.println("6 - 6 задание");
            System.out.println("7 - 7 задание");
            System.out.println("8 - 8 задание");
            System.out.println("9 - *9 задание");
            System.out.println("0 - Выход");
            int res = scanner.nextInt();

            if (res == 1)
                table();
            if (res == 2) {
                System.out.print("Введите количество чисел Фибоначчи: ");
                int len = scanner.nextInt();
                System.out.println("Введите вариант цикла:" + '\n'
                        + "1 - for" + '\n'
                        + "2 - while" + '\n'
                        + "3 - do while");
                fibonacci(len, scanner.nextInt());
            }
            if (res == 3) {
                System.out.print("Введите число: ");
                int num = scanner.nextInt();
                System.out.println("Введите вариант цикла:" + '\n'
                        + "1 - for" + '\n'
                        + "2 - while");
                sumOfNumber(num, scanner.nextInt());
            }
            if (res == 4) {
                System.out.println("Введите набор слов: ");
                scanner.nextLine();
                palindromesCount(scanner.nextLine());
            }
            if (res == 5)
                luckyTime();
            if (res == 6) {
                System.out.print("Введите число месяца: ");
                int m = scanner.nextInt();
                System.out.println("Введите вариант условного оператора:" + '\n'
                        + "1 - if" + '\n'
                        + "2 - switch");
                month(m, scanner.nextInt());
            }
            if (res == 7) {
                System.out.print("Введите десятичное число: ");
                decimalToBinary(scanner.nextInt());
            }
            if (res == 8) {
                System.out.print("Введите степень: ");
                degree(scanner.nextInt());
            }
            if (res == 9) {
                System.out.print("Введите число: ");
                recursionSumOfNumber(scanner.nextInt());
            }
            if (res == 0)
                break;
            else
                System.out.println("Такого задания нет!");
        }
    }
}
