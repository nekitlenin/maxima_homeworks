import java.util.Arrays;

/**
 * Project: homework14
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 08.02.2023 17:36 |
 * Created with IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        Byte[] mas1 = {1, 4, 5, 10, 44, Byte.MIN_VALUE, 3, Byte.MAX_VALUE};
        minMax(mas1);
        Short[] mas2 = {1, 2, Short.MAX_VALUE, 23424, 5234, 2423, Short.MIN_VALUE};
        minMax(mas2);
        Integer[] mas3 = {1, 2, Integer.MIN_VALUE, 23424, 5234, 2423, Integer.MAX_VALUE};
        minMax(mas3);
        Long[] mas4 = {1L, 2L, Long.MIN_VALUE, 23424L, 5234L, 2423L, Long.MAX_VALUE};
        minMax(mas4);
        Float[] mas5 = {1.1f, Float.MAX_VALUE, Float.MIN_VALUE, 2.5f, 100.423f, 234242.4f, 5234534.242342f};
        minMax(mas5);
        Double[] mas6 = {1.1d, 2.5d, 100.423d, Double.MAX_VALUE, 234242.4d, 5234534.242342d, Double.MIN_VALUE};
        minMax(mas6);
    }

    public static <T extends Number> MinMaxNumbers<T, T> minMax(T[] mas) {
        Arrays.sort(mas);
        MinMaxNumbers<T, T> minMaxNumbers = new MinMaxNumbers<>(mas[0], mas[mas.length - 1]);
        System.out.println(mas[0].getClass().getSimpleName()
                + " min: " + minMaxNumbers.getMin() + " max: " + minMaxNumbers.getMax());
        return minMaxNumbers;
    }
}
