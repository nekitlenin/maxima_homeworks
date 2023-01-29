/**
 * Project: seaBattle
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 27.01.2023 16:06 |
 * Created with IntelliJ IDEA
 */
public enum EnumShip {
    BOAT("Boat", "Лодка", 1, 4),
    DESTROYER("Destroyer", "Эсминец", 2, 3),
    CRUISER("Cruiser", "Крейсер", 3, 2),
    BATTLESHIP("Battleship", "Линкор", 4, 1);

    final private String name;
    final private String info;
    final private int size;
    final private int count;

    EnumShip(String name, String info, int size, int count) {
        this.name = name;
        this.info = info;
        this.size = size;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public int getSize() {
        return size;
    }

    public int getCount() {
        return count;
    }
}
