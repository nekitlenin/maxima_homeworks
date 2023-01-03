/**
 * Project: homework07
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 02.01.2023 01:27 |
 * Created with IntelliJ IDEA
 */
public class Player {
    String name;
    int shore;

    /** Конструкторы */
    public Player(String name, int shore) {
        this.name = name;
        this.shore = shore;
    }

    public Player(String name) {
        this.name = name;
    }

    public Player(int shore) {
        this.shore = shore;
    }

    /** Метод выстрела по координатам
     * @param x координата x
     * @param y координата y
     * @return текст выстрела по координатам */
    public String shoot(int x, int y){
        return "Игрок " + name + " ударил по ячейке " + x + " : " + y;
    }

    /** Геттер, возвращает имя игрока
     * @return name - имя игрока */
    public String getName() {
        return name;
    }

    /** Сеттер для создания / смены имени
     * @param name имя игрока */
    public void setName(String name) {
        this.name = name;
    }

    /** Геттер, возвращает счёт игрока
     * @return shore - счёт игрока */
    public int getShore() {
        return shore;
    }

    /** Добавляет балл к счёту игрока */
    public void upShore() {
        this.shore++;
    }
}

