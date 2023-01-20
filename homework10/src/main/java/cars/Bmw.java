package cars;

/**
 * Project: homework10
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 18.01.2023 14:24 |
 * Created with IntelliJ IDEA
 */
public class Bmw extends Car {
    private static final String NAME = "BMW";
    private int maxSpeed;

    public Bmw(String model, int price, String color, int width, int height, int length, int weigh) {
        super(model, price, color, width, height, length, weigh);
        super.country = "Germany";
    }

    public Bmw(String model, int price, String color, int width, int height, int length, int weigh, int maxSpeed) {
        super(model, price, color, width, height, length, weigh);
        super.country = "Germany";
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void ride() {
        System.out.println(NAME + " поехала: Дрын дрын дрын");
    }

    @Override
    public void brake() {
        System.out.println(NAME + ": Эффективность торможения - 45%");
    }

    @Override
    public void takeFuel() {
        System.out.println(NAME + ": Заправка прошла успешно! Топливо АИ-95");
    }

    public void makeChipTuning() {
        System.out.println(NAME + ": Чип-тюнинг сделан! Максимальная скорость - " + (maxSpeed += 20));
    }

    @Override
    protected String getModel() {
        return super.getModel();
    }

    @Override
    public void setModel(String model) {
        super.setModel(model);
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
