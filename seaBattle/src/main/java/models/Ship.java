package models;

/**
 * Project: seaBattle
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 04.01.2023 04:42 |
 * Created with IntelliJ IDEA
 */
public class Ship {
    final private EnumShip enumShip;
    private Player player;

    /**
     * Конструкторы
     */
    public Ship(Player player, EnumShip enumShip) {
        this.player = player;
        this.enumShip = enumShip;
    }

    public EnumShip getEnumShip() {
        return enumShip;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
