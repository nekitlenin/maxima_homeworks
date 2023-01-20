package cars;

/**
 * Project: homework10
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 18.01.2023 14:24 |
 * Created with IntelliJ IDEA
 */
public class Tesla extends Car {
    private static final String NAME = "Tesla";
    private static final int MAX_MILEAGE = 500;
    private int mileAge; // пробег

    public Tesla(String model, int price, String color, int width, int height, int length, int weigh) {
        super(model, price, color, width, height, length, weigh);
        super.country = "USA";
    }

    public Tesla(String model, int price, String color, int width, int height, int length, int weigh, int mileAge) {
        super(model, price, color, width, height, length, weigh);
        super.country = "USA";
        this.mileAge = mileAge;
    }

    @Override
    public void ride() {
        if (mileAge > 100)
            System.out.println(NAME + " поехала: тишина, в запасе: " + (mileAge -= 100) + " km хода!");
        else
            System.out.println(NAME + " требуется зарядка!");
    }

    @Override
    public void brake() {
        System.out.println(NAME + ": Эффективность торможения - 95%");
    }

    @Override
    public void takeFuel() {
        super.takeFuel();
    }

    public void takeEnergy() {
        System.out.println(NAME + ": Зарядка прошла успешно! В запасе: " + (mileAge = MAX_MILEAGE) + " km хода!");
    }

    public void onAutoPilot() {
        System.out.println(NAME + ": Автопилот активен!");
    }

    public void offAutoPilot() {
        System.out.println(NAME + ": Автопилот выключен!");
    }

    public int getMileAge() {
        return mileAge;
    }

    public void setMileAge(int mileAge) {
        if (mileAge <= 500)
            this.mileAge = mileAge;
        else
            this.mileAge = MAX_MILEAGE;
    }

}
