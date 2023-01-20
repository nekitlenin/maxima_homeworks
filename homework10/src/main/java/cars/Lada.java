package cars;

/**
 * Project: homework10
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 18.01.2023 14:24 |
 * Created with IntelliJ IDEA
 */
public class Lada extends Car {
    private static final String NAME = "Lada";
    private String equipment;

    public Lada(String model, int price, String color, int width, int height, int length, int weigh) {
        super(model, price, color, width, height, length, weigh);
        super.country = "Russia";
    }

    public Lada(String model, int price, String color, int width, int height, int length, int weigh, String equipment) {
        super(model, price, color, width, height, length, weigh);
        super.country = "Russia";
        this.equipment = equipment;
    }

    @Override
    public void ride() {
        System.out.println(NAME + " поехала: Тыр тыр тыр");
    }

    @Override
    public void brake() {
        System.out.println(NAME + ": Эффективность торможения - 30%");
    }

    @Override
    public void takeFuel() {
        System.out.println(NAME + ": Заправка прошла успешно! Топливо  АИ-90!");
    }

    public void brokeEngine() {
        System.out.println(NAME + ": Двигатель сломался!");
    }

    public void fixEngine() {
        System.out.println(NAME + ": Двигатель восстановлен!");
    }

    public void makeBlackWindows() {
        equipment += " + black windows";
        System.out.println(NAME + ": Тонировка сделана! Комлпектация: " + getEquipment());
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}
