/**
 * Project: homework08
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 04.01.2023 04:42 |
 * Created with IntelliJ IDEA
 */
public class Player {
    String name;
    int shore;
    Map map;
    int[] shipList;

    /** Конструкторы */
    public Player(String name) {
        this.name = name;
        this.shipList = new int[getShipCount()];
    }

    public int getShipCount() {
        int count = 0;
        for (int i = 0; i < Map.shipCount.length; i++)
            count += Map.shipCount[i];
        return count;
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

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int[] getShipList() {
        return shipList;
    }
}


