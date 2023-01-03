/**
 * Project: homework07
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 02.01.2023 01:28 |
 * Created with IntelliJ IDEA
 */
public class Ship {
    int size;
    String name;

    /** Конструкторы */
    public Ship(int size, String name) {
        this.size = size;
        this.name = name;
    }

    public Ship(int size) {
        this.size = size;
    }

    public Ship(String name) {
        this.name = name;
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
}
