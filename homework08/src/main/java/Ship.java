/**
 * Project: homework08
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 04.01.2023 04:42 |
 * Created with IntelliJ IDEA
 */
public class Ship {
    private static final String BOAT = "Boat";
    private static final String DESTROYER = "Destroyer";
    private static final String CRUISER = "Cruiser";
    private static final String BATTLESHIP = "Battleship";
    private String name;
    private int size;
    private Player player;

    /**
     * Конструкторы
     */
    public Ship(int size, Player player) {
        if (size == 1)
            this.name = BOAT;
        else if (size == 2)
            this.name = DESTROYER;
        else if (size == 3)
            this.name = CRUISER;
        else if (size == 4)
            this.name = BATTLESHIP;
        else
            System.err.println("Игрок " + player.name + ", введите размер корабля от 1 до 4");
        this.size = size;
        this.player = player;
    }

    /**
     * Геттер, получить размер корабля
     *
     * @return size - размер корабля
     */
    public int getSize() {
        return size;
    }

    /**
     * Сеттер, задать / изменить размер корабля
     *
     * @param size размер корабля
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Геттер, получить имя корабля
     *
     * @return name - имя корабля
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер, задать / изменить имя корабля
     *
     * @param name имя корабля
     */
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
