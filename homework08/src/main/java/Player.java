/**
 * Project: homework08
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 04.01.2023 04:42 |
 * Created with IntelliJ IDEA
 */
public class Player {
    private final Ship[] SHIP_LIST;
    String name;
    private int shore;
    private Map map;

    /**
     * Конструкторы
     */
    public Player(String name) {
        this.name = name;
        this.SHIP_LIST = new Ship[getShipCount()];
    }

    private int getShipCount() {
        int count = 0;
        for (int i = 0; i < Map.SHIP_COUNT.length; i++)
            count += Map.SHIP_COUNT[i];
        return count;
    }

    /**
     * Метод выстрела по координатам
     *
     * @param x координата x
     * @param y координата y
     * @return текст выстрела по координатам
     */
    public String shoot(int x, int y) {
        return "Игрок " + name + " ударил по ячейке " + x + " : " + y;
    }

    /**
     * Геттер, возвращает имя игрока
     *
     * @return name - имя игрока
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер для создания / смены имени
     *
     * @param name имя игрока
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер, возвращает счёт игрока
     *
     * @return shore - счёт игрока
     */
    public int getShore() {
        return shore;
    }

    /**
     * Добавляет балл к счёту игрока
     */
    public void upShore() {
        this.shore++;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Ship[] getSHIP_LIST() {
        return SHIP_LIST;
    }
}
