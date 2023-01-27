package Enum;

/**
 * Project: homework11
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 25.01.2023 17:56 |
 * Created with IntelliJ IDEA
 */
public enum DayOfWeek {
    MONDAY("Понедельник", 1),
    TUESDAY("Вторник", 2),
    WEDNESDAY("Среда", 3),
    THURSDAY("Четверг", 4),
    FRIDAY("Пятница", 5),
    SATURDAY("Суббота", 6),
    SUNDAY("Воскресенье", 7);

    private final String dayOfWeek;
    private final int numOfWeek;

    DayOfWeek(String dayOfWeek, int numOfWeek) {
        this.dayOfWeek = dayOfWeek;
        this.numOfWeek = numOfWeek;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getNumOfWeek() {
        return numOfWeek;
    }
}
