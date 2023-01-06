import java.util.Arrays;

/**
 * Project: homework08
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 04.01.2023 04:57 |
 * Created with IntelliJ IDEA
 */
public class Map {
    static int[] shipCount = {4, 3, 2, 1};
    int[][] map = new int[10][10];
    Player player;

    /** Конструктор */
    public Map(Player player) {
        this.player = player;
    }

    /** Соответственно по умолчанию все ячейки стоят с 0,
     *  когда вызываем один из 4 методов
     *  (1.поставить корабль, 2.промах, 3.попадание, 4.убил)
     *  значение в указанной ячейке меняется на нужный */
    public void putBoat(int x, int y) {
        map[x][y] = 1;
        System.out.println("Корабль поставлен");
    }

    public void missBoat(int x, int y) {
        map[x][y] = 2;
        System.out.println("Промах");
    }

    public void hitBoat(int x, int y) {
        map[x][y] = 3;
        System.out.println("Ранил");
    }

    public void killBoat(int x, int y) {
        map[x][y] = 4;
        System.out.println("Убил");
    }

    /** Вывод карты */
    public void showMap() {
        System.out.println("Поле игрока " + player.name);
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
}
