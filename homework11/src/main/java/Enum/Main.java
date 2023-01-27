package Enum;

import java.util.Arrays;

import static Enum.DayOfWeek.*;
import static Enum.Month.*;

/**
 * Project: homework11
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 25.01.2023 18:23 |
 * Created with IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(MONDAY);
        System.out.println(FRIDAY.getDayOfWeek());
        System.out.println(SUNDAY.getDayOfWeek() + ", порядковый номер - " + SUNDAY.getNumOfWeek());
        System.out.println(Arrays.toString(DayOfWeek.values()));
        for (DayOfWeek day : DayOfWeek.values())
            System.out.print(day.getDayOfWeek() + " ");

        System.out.println('\n');

        System.out.println(AUGUST);
        System.out.println(MARCH.getMonth());
        System.out.println(JUNE.getMonth());
        System.out.println(Arrays.toString(Month.values()));
        for (Month m : Month.values())
            System.out.print(m.getMonth() + " ");
    }
}
