/**
 * Project: homework08
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 04.01.2023 04:42 |
 * Created with IntelliJ IDEA
 */
public class Ship {
    static String name1 = "Boat";
    static String name2 = "Destroyer";
    static String name3 = "Cruiser";
    static String name4 = "Battleship";
    String name;
    int size;
    Player player;

    /** Конструкторы */
    public Ship(String name, int size, Player player) {
        this.name = name;
        this.size = size;
        this.player = player;
    }

    public Ship(String name, Player player) {
        this.name = name;
        this.player = player;
    }

    public Ship(int size, Player player) {
        this.size = size;
        this.player = player;
    }

    /** Геттер, получить размер корабля
     * @return size - размер корабля */
    public int getSize() {
        return size;
    }

    /** Сеттер, задать / изменить размер корабля
     *  @param  size размер корабля */
    public void setSize(int size) {
        this.size = size;
    }

    /** Геттер, получить имя корабля
     *  @return name - имя корабля */
    public String getName() {
        return name;
    }

    /** Сеттер, задать / изменить имя корабля
     * @param name имя корабля */
    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
