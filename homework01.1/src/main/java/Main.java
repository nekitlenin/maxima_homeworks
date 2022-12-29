/**
 * Project: homework01.1
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 22.12.2022 12:30 |
 * Created with IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        /** От -128 до 127 (8 бит) */
        byte b = 1;

        /** От -32768 до 32767 (16 бит) */
        short s = 12;

        /** От -2147483648 до 2147483647 (32 бит) */
        int i = 123;

        /** От -9 * 10^18 до 9 * 10^18 (64 бит) */
        long l = 1234;

        /** От -3,4 * 10^38 до 3,4 * 10^38 (32 бит) */
        float f = 12.345f;

        /** От +-5,0 * 10^-324 до +-1,7 * 10^308 (64 бит) */
        double d = 12.3456;

        /** True или False */
        boolean isCheck = true;

        /** От 0 до 65535 (16 бит) */
        char c = 'a';

        System.out.println("byte - " + b);
        System.out.println("short - " + s);
        System.out.println("int - " + i);
        System.out.println("long - " + l);
        System.out.println("float - " + f);
        System.out.println("double - " + d);
        System.out.println("boolean - " + isCheck);
        System.out.println("char - " + c);

    }
}
