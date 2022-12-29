/**
 * Project: homework06
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 29.12.2022 08:23 |
 * Created with IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        String[] season = {"Winter", "Spring", "Summer", "Autumn"};
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};
        String[] dayWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] day = new int[31];
        int j = 1;

        for (int i = 0; i < 31; i++)
            day[i] = j++;
        System.out.println("Today is - " + season[0]
                + ", month: " + month[11]
                + ", day of week: " + dayWeek[3]
                + ", day: " + day[28]);
        System.out.println("My birthday is - " + season[2]
                + ", month: " + month[7]
                + ", day of week: " + dayWeek[0]
                + ", day: " + day[13]);
        System.out.println(season[0] + " - " + season[3]);
        System.out.println(month[0] + " - " + month[11]);
        System.out.println(dayWeek[0] + " - " + dayWeek[6]);
        System.out.println(day[0] + " - " + day[30]);
    }
}
