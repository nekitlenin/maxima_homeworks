/**
 * Project: homework06
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 29.12.2022 09:07 |
 * Created with IntelliJ IDEA
 */
public class Bonus {
    public static void main(String[] args) {
        int[][] monthsWithDays = new int[12][31];

        for (int i = 0; i < 12; i++) {
            int numDay = 1;
            for (int j = 0; j < 31; j++)
                monthsWithDays[i][j] = numDay++;
        }
        for (int i = 0; i < 12; i++) {
            System.out.println("MONTH: " + (i + 1));
            for (int j = 0; j < 31; j++) {
                System.out.println("day - " + monthsWithDays[i][j]);
            }
        }
    }
}
